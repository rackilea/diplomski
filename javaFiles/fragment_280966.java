private static void processImageResultSet(ResultSet rs) throws SQLException, FileNotFoundException, IOException{

        int i = 0;                  //used as a count and to name various temp files
        while(rs.next()){           //loop through result sets

        byte[] b = rs.getBytes(1);                                 //the bytea column result
        String location = getFileName(rs.getString(2));            //the name of the jpg file
        ByteArrayInputStream bis = new ByteArrayInputStream(b);    //creates stream storing byts

        //To make individual names of temporary files unique the current time and date is stored
        SimpleDateFormat df = new SimpleDateFormat("'Date 'yyyy-MM-dd HH'H'-mm'M'-ss'secs'-SS'ms'"); //formats date string
        Calendar cal = Calendar.getInstance();                                //gets instance of calendar time
        String fileDate = df.format(cal.getTime());                           //gets the time and date as a String

        Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");     //creates a reader object, that will read jpg codec compression format
        Object source = bis;                                                  //object to store stream of bytes from database
        ImageReader reader = (ImageReader) readers.next();                      
        ImageInputStream iis = ImageIO.createImageInputStream(source);        //creates image input stream from object source which stores byte stream

        reader.setInput(iis, true);             //sets the reader object to read image input stream

        ImageReadParam param = reader.getDefaultReadParam(); 
        Image image = reader.read(0, param);

        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);   //creates buffered image

        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, null, null);
        File imageFile = new File(location + " " + fileDate + " " + i + ".jpg"); //creates image file 
        ImageIO.write(bufferedImage, "jpg", imageFile);                          //writes buffered image object to created file

        i++;        //counts number of results from query within the ResultSet 
        }

    }