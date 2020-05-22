class Meta {
    public String num;
    public String type;
    public String ext;

    Meta(String num, String ext, String type) {
        this.num = num;
        this.ext = ext;
        this.type = type;
    }
}

class Video {
    public String ext = "";
    public String type = "";
    public String url = "";

    Video(String ext, String type, String url) {
        this.ext = ext;
        this.type = type;
        this.url = url;
    }
}

public ArrayList<Video> getStreamingUrisFromYouTubePage(String ytUrl)
        throws IOException {
    if (ytUrl == null) {
        return null;
    }

    // Remove any query params in query string after the watch?v=<vid> in
    // e.g.
    // http://www.youtube.com/watch?v=0RUPACpf8Vs&feature=youtube_gdata_player
    int andIdx = ytUrl.indexOf('&');
    if (andIdx >= 0) {
        ytUrl = ytUrl.substring(0, andIdx);
    }

    // Get the HTML response
    /* String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:8.0.1)";*/
   /* HttpClient client = new DefaultHttpClient();
    client.getParams().setParameter(CoreProtocolPNames.USER_AGENT,
            userAgent);
    HttpGet request = new HttpGet(ytUrl);
    HttpResponse response = client.execute(request);*/
    String html = "";
    HttpsURLConnection c = (HttpsURLConnection) new URL(ytUrl).openConnection();
    c.setRequestMethod("GET");
    c.setDoOutput(true);
    c.connect();
    InputStream in = c.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    StringBuilder str = new StringBuilder();
    String line = null;
    while ((line = reader.readLine()) != null) {
        str.append(line.replace("\\u0026", "&"));
    }
    in.close();
    html = str.toString();

    // Parse the HTML response and extract the streaming URIs
    if (html.contains("verify-age-thumb")) {
        Log.e("Downloader", "YouTube is asking for age verification. We can't handle that sorry.");
        return null;
    }

    if (html.contains("das_captcha")) {
        Log.e("Downloader", "Captcha found, please try with different IP address.");
        return null;
    }

    Pattern p = Pattern.compile("stream_map\":\"(.*?)?\"");
    // Pattern p = Pattern.compile("/stream_map=(.[^&]*?)\"/");
    Matcher m = p.matcher(html);
    List<String> matches = new ArrayList<String>();
    while (m.find()) {
        matches.add(m.group());
    }

    if (matches.size() != 1) {
        Log.e("Downloader", "Found zero or too many stream maps.");
        return null;
    }

    String urls[] = matches.get(0).split(",");
    HashMap<String, String> foundArray = new HashMap<String, String>();
    for (String ppUrl : urls) {
        String url = URLDecoder.decode(ppUrl, "UTF-8");
        Log.e("URL","URL : "+url);

        Pattern p1 = Pattern.compile("itag=([0-9]+?)[&]");
        Matcher m1 = p1.matcher(url);
        String itag = null;
        if (m1.find()) {
            itag = m1.group(1);
        }

        Pattern p2 = Pattern.compile("signature=(.*?)[&]");
        Matcher m2 = p2.matcher(url);
        String sig = null;
        if (m2.find()) {
            sig = m2.group(1);
        } else {
            Pattern p23 = Pattern.compile("signature&s=(.*?)[&]");
            Matcher m23 = p23.matcher(url);
            if (m23.find()) {
                sig = m23.group(1);
            }
        }

        Pattern p3 = Pattern.compile("url=(.*?)[&]");
        Matcher m3 = p3.matcher(ppUrl);
        String um = null;
        if (m3.find()) {
            um = m3.group(1);
        }

        if (itag != null && sig != null && um != null) {
            Log.e("foundArray","Adding Value");
            foundArray.put(itag, URLDecoder.decode(um, "UTF-8") + "&"
                    + "signature=" + sig);
        }
    }
    Log.e("foundArray","Size : "+foundArray.size());
    if (foundArray.size() == 0) {
        Log.e("Downloader", "Couldn't find any URLs and corresponding signatures");
        return null;
    }


    ArrayList<Video> videos = new ArrayList<Video>();

    for (String format : typeMap.keySet()) {
        Meta meta = typeMap.get(format);

        if (foundArray.containsKey(format)) {
            Video newVideo = new Video(meta.ext, meta.type,
                    foundArray.get(format));
            videos.add(newVideo);
            Log.d("Downloader", "YouTube Video streaming details: ext:" + newVideo.ext
                    + ", type:" + newVideo.type + ", url:" + newVideo.url);
        }
    }

    return videos;
}

private class YouTubePageStreamUriGetter extends AsyncTask<String, String, ArrayList<Video>> {
    ProgressDialog progressDialog;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(webViewActivity.this, "",
                "Connecting to YouTube...", true);
    }

    @Override
    protected ArrayList<Video> doInBackground(String... params) {
        ArrayList<Video> fVideos = new ArrayList<>();
        String url = params[0];
        try {
            ArrayList<Video> videos = getStreamingUrisFromYouTubePage(url);
            /*                Log.e("Downloader","Size of Video : "+videos.size());*/
            if (videos != null && !videos.isEmpty()) {
                for (Video video : videos)
                {
                    Log.e("Downloader", "ext : " + video.ext);
                    if (video.ext.toLowerCase().contains("mp4") || video.ext.toLowerCase().contains("3gp") || video.ext.toLowerCase().contains("flv") || video.ext.toLowerCase().contains("webm")) {
                        ext = video.ext.toLowerCase();
                        fVideos.add(new Video(video.ext,video.type,video.url));
                    }
                }


                return fVideos;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Downloader", "Couldn't get YouTube streaming URL", e);
        }
        Log.e("Downloader", "Couldn't get stream URI for " + url);
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Video> streamingUrl) {
        super.onPostExecute(streamingUrl);
        progressDialog.dismiss();
        if (streamingUrl != null) {
            if (!streamingUrl.isEmpty()) {
                //Log.e("Steaming Url", "Value : " + streamingUrl);

                for (int i = 0; i < streamingUrl.size(); i++) {
                    Video fX = streamingUrl.get(i);
                    Log.e("Founded Video", "URL : " + fX.url);
                    Log.e("Founded Video", "TYPE : " + fX.type);
                    Log.e("Founded Video", "EXT : " + fX.ext);
                }
                //new ProgressBack().execute(new String[]{streamingUrl, filename + "." + ext});
            }
        }
    }
}
public void initTypeMap()
{
    typeMap.put("13", new Meta("13", "3GP", "Low Quality - 176x144"));
    typeMap.put("17", new Meta("17", "3GP", "Medium Quality - 176x144"));
    typeMap.put("36", new Meta("36", "3GP", "High Quality - 320x240"));
    typeMap.put("5", new Meta("5", "FLV", "Low Quality - 400x226"));
    typeMap.put("6", new Meta("6", "FLV", "Medium Quality - 640x360"));
    typeMap.put("34", new Meta("34", "FLV", "Medium Quality - 640x360"));
    typeMap.put("35", new Meta("35", "FLV", "High Quality - 854x480"));
    typeMap.put("43", new Meta("43", "WEBM", "Low Quality - 640x360"));
    typeMap.put("44", new Meta("44", "WEBM", "Medium Quality - 854x480"));
    typeMap.put("45", new Meta("45", "WEBM", "High Quality - 1280x720"));
    typeMap.put("18", new Meta("18", "MP4", "Medium Quality - 480x360"));
    typeMap.put("22", new Meta("22", "MP4", "High Quality - 1280x720"));
    typeMap.put("37", new Meta("37", "MP4", "High Quality - 1920x1080"));
    typeMap.put("33", new Meta("38", "MP4", "High Quality - 4096x230"));
}