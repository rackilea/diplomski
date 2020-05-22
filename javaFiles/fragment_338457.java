Bundle extras = getIntent().getExtras();
String temp = (String) extras.get("temp");

String ikona = (String) extras.get("ikony");
URLs = "http://openweathermap.org/img/w/"+ikona+".png";
Log.d("asd",URLs);

Thread thread = new Thread(new Runnable() {

    public void run() {
        try {
            URL url = new URL(URLs);
            Bitmap bmp= BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
            imageView1.setImageBitmap(bmp);
        }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
});
thread.start();