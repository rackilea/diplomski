for (int i = 1; i <= numberOfSplits; i++) {
            String name = file.getName();
            byte[] b = parts[i - 1].getBytes(Charset.forName("UTF-8"));
            ByteArrayInputStream bis = new ByteArrayInputStream(b);

            int temp = 0;
            File newFile = new File(name + " " + i + ".txt");
            newFile.createNewFile();
            FileOutputStream out = new FileOutputStream(newFile);                    
            while ((temp = bis.read()) > 0)
            {
                out.write(temp); // Writes to the file
            }
            out.flush();
            out.close();
        }