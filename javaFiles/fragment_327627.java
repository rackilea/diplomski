ArrayList<String> urls=new ArrayList<String>();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    try {
        // Create a URL for the desired page
        URL url = new URL("yyyyy.de/test.txt"); //My text file location

        // Read all the text returned by the server
        BufferedReader in = new BufferedReader(new     InputStreamReader(url.openStream()));
        String str;
        while ((str = in.readLine()) != null) {
            urls.add(str);
        }
        in.close();
       } catch (MalformedURLException e) {
      } catch (IOException e) {
     }

Log.i("test","url count="+urls.size());


    boolean isPLAYING = false;

    if (!isPLAYING) {
        isPLAYING = true;
        MediaPlayer mp = new MediaPlayer();
        try {
            int randomPos = new Random().nextInt(urls.size());
            mp.setDataSource(urls.get(randomPos));
            mp.prepare();
            mp.start();
        } catch (IOException e) {

        }
    } else {
        isPLAYING = false;

    }

}