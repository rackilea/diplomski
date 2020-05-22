public void download(String project, String version, String location)
{
    for(S3ObjectSummary s: getObjectList())
    {
        String[] data = s.getKey().split("/");
        if(data[0].equals(project) && data[1].equals(version))
        {
            S3Object object = s3.getObject(s3BucketName,s.getKey());
            InputStream input = object.getObjectContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            File file = new File(location +"/"+ data[0] + "/" + data[2] + "/" + data[3] + "/" + data[4]);
            if(!file.exists())
            {
                  try {
                      file.getParentFile().mkdirs();
                        file.createNewFile();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
            try 
            {
                if(data[4].endsWith(".java"))
                {
                Writer writer = new OutputStreamWriter(new FileOutputStream(file));
                while (true) {          
                     String line = reader.readLine();           
                     if (line == null)
                          break;            

                     writer.write(line + "\n");
                }

                writer.close();
                }
                else if(data[4].endsWith(".class"))
                {
                    System.out.println("Writing Classes");
                    byte[] buffer = new byte[8 * 1024];

                    try {
                          OutputStream output = new FileOutputStream(file.getAbsolutePath());
                          try {
                            int bytesRead;
                            while ((bytesRead = input.read(buffer)) != -1) {
                              output.write(buffer, 0, bytesRead);
                            }
                          } finally {
                            output.close();
                          }
                        } finally {
                          input.close();
                        }
                }

            } catch (FileNotFoundException e) {

                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }
    }
}