URL url;
            URLConnection con;
            DataInputStream dis; 
            FileOutputStream fos; 
            byte[] fileData;  
            try {
                url = new URL("http://website.com/file.pdf"); //File Location goes here
                con = url.openConnection(); // open the url connection.
                dis = new DataInputStream(con.getInputStream());
                fileData = new byte[con.getContentLength()]; 
                for (int q = 0; q < fileData.length; q++) { 
                    fileData[q] = dis.readByte();
                }
                dis.close(); // close the data input stream
                fos = new FileOutputStream(new File("/Users/kfang/Documents/Download/file.pdf")); //FILE Save Location goes here
                fos.write(fileData);  // write out the file we want to save.
                fos.close(); // close the output stream writer
            }
            catch(Exception m) {
                System.out.println(m);
            }