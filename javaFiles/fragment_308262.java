bm=null;   // Bad idea to init this BitMap to null !!!!!!


 try {       
        UrlImage = new URL (file);
        HttpURLConnection connection;
        connection = (HttpURLConnection) UrlImage.openConnection(); 
        bm= BitmapFactory.decodeStream(connection.getInputStream());
     }
    catch{...}