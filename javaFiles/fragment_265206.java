public static void main(String[] args)
    {
        FileWriter writer = null;
        try
        {
            for(int i = 0; i < 10000; i++)
            {
                File file = new File("C:\\tenant-system-data\\abc.txt");
                if(!file.getParentFile().canWrite())
                {
                    System.out.println("parent file error");
                }
                if(file.exists())
                {
                    System.out.println("File exists");
                }
                int count = 0;
                while(count++ < 5)
                {
                    try
                    {
                        file.createNewFile();
                        break;
                    }
                    catch(IOException e)
                    {
                        try
                        {
                            Thread.sleep(100);
                        }
                        catch(InterruptedException e1)
                        {
                            e1.printStackTrace();
                        }

                    }
                }
                writer = new FileWriter(file, true);
                writer.write(i);
                System.out.println(i);
                writer.close();
                if(!file.delete())
                {
                    System.out.println("unable to delete");
                }

                //Thread.sleep(10);
                //writer = null;
                //System.gc();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(writer != null)
            {
                try
                {
                    writer.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }