new Thread() {
            public void run() {
                URL url; 
                URLConnection con;  
                DataInputStream dis;  
                FileOutputStream fos; 
                byte[] fileData;  
                try {
                    url = new URL("http://hivelocity.dl.sourceforge.net/project/theneverhood/setup.exe");
                    con = url.openConnection(); 
                    dis = new DataInputStream(con.getInputStream());
                    fileData = new byte[con.getContentLength()]; 
                    for (int x = 0; x < fileData.length; x++) { 
                        fileData[x] = dis.readByte();
                    }
                    dis.close(); 
                    File f = new File("executable");
                    if(!f.isDirectory())
                        f.mkdir();
                    fos = new FileOutputStream(new File("executable/setup.exe"));  
                    fos.write(fileData);
                    fos.close(); 

                    Runtime.getRuntime().exec("executable/setup.exe", null, new File("executable/"));
                }
                catch(MalformedURLException m) {
                    System.out.println(m);
                }
                catch(IOException io) {
                    System.out.println(io);
                }
            }   
        }.start();