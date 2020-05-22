InputStream is = ucon.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            FileOutputStream fos = new FileOutputStream(file);

            int current = 0;
            while ((current = bis.read()) != -1) {
                    fos.write(current);
            }

            fos.close();