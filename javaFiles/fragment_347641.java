switch (method){
        case "ping": {
            try{
                data = URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("ping", "UTF-8");
                Log.e(TAG,"DATA: " + data);
            }catch (UnsupportedEncodingException e){
                Log.e(TAG, "UnsupportedEncodingException: " + e.toString());
            }
            try {
                URL url = new URL(link);
                HttpURLConnection h = (HttpURLConnection) url.openConnection();
                h.setDoInput(true);
                h.setDoOutput(true);
                OutputStreamWriter owriter =
                        new OutputStreamWriter(h.getOutputStream());
                owriter.write(data);
                owriter.flush();
                BufferedReader b = new BufferedReader
                        (new InputStreamReader(h.getInputStream(), "UTF-8"), 8);
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = b.readLine()) != null) {
                    builder.append(line);
                }
                return builder.toString();
            } catch (IOException e) {
                Log.e(TAG, "IOException: " + e.toString());
            }
        }
        break;
    case "updatecounter": {