FileInputStream fi = new FileInputStream(file);
            byte[] downloadStream = new byte[(int) file.length()];
            fi.read(downloadStream);
            InputStream is = new ByteArrayInputStream(downloadStream); // read it with BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;

            while ((line = br.readLine()) != null) {
                x.append(line.trim());
            }