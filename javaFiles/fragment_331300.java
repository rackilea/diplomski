br = new BufferedReader(new FileReader("C:\\testing.txt"));

String line="";
                while ((line = br.readLine()) != null) {
                    theLine+=line;
                }