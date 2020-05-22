String url = "https://dl.jatt.link/hd.jatt.link/a0339e7c772ed44a770a3fe29e3921a8/uttzv/Hummer-(Mr-Jatt.com).mp3";
String filename = "C:/Songs/newsong.mp3";
Response r = Jsoup.connect(url)
    //.followRedirects(true) // follow redirects (it's the default)
    .ignoreContentType(true) // accept not just HTML
    .maxBodySize(10*1000*1000) // accept 10M bytes (default is 1M), or set to 0 for unlimited
    .execute(); // send GET request
FileOutputStream out = new FileOutputStream(new File(filename));
out.write(r.bodyAsBytes());
out.close();