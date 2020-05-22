while (scanner.hasNextLine()) {

                   scanner.useDelimiter("\\Z");
                   String data = scanner.next();
                   String cleaned = data.replaceAll("/\\*(?:.|[\\n\\r])*?\\*/",""));
                   LineNumberReader lnr = new LineNumberReader(new StringReader(cleaned));
                   String line;
                   while ((line = lnr.readLine()) != null)
                    {
                      String sline = line.trim();
                      if(sline.isEmpty() == false)
                      if(!(sline.length() > 2 && sline.charAt(0) == '/' && sline.charAt(1) == '/'))
                          lineCount += 1;
                           //separated for clarity
                   }


                }