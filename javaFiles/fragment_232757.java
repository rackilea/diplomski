public String getpage(URL url)
    {
        try {
            // try opening the URL
            URLConnection urlConnection = url.openConnection();                        
            urlConnection.setAllowUserInteraction(false);

            InputStream urlStream = url.openStream();            
            byte buffer[] = new byte[1000];
            int numRead = urlStream.read(buffer);
            String content = new String(buffer, 0, numRead);

            while ((numRead != -1) && (content.length() < MAX_PAGE_SIZE)) {
                numRead = urlStream.read(buffer);
                if (numRead != -1) {
                    String newContent = new String(buffer, 0, numRead);
                    content += newContent;
                }
            }
            return content;
        } catch (IOException e) {            
            e.printTrackStace();
        }catch(IndexOutOfBoundsException e1){            
            e1.printTrackStace();
        }
    }