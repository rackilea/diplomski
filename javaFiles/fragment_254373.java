File syncDatafile = new File(file, "sync.txt");
                FileOutputStream fileoutputStream = new FileOutputStream (syncDatafile);
                java.nio.channels.FileLock lock = fileInputStream.getChannel().lock();
                try{
                    FileWriter writer = new FileWriter(syncDatafile, true);
                    writer.write(data);
                    writer.flush();
                    writer.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }finally{
                    lock.release();
                    fileInputStream.close();
                }