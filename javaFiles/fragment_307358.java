urlConnection.setRequestProperty("Content-Length", String.valueOf(query.getBytes().length));            
    urlConnection.setFixedLengthStreamingMode(query.getBytes().length);

    OutputStream output = new BufferedOutputStream(urlConnection.getOutputStream());            
    output.write(query.getBytes());
    output.flush(); 
    output.close();