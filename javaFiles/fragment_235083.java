InputStream in = null;
            CompilationUnit cu = null;
            try
            {
                    in = new SEDInputStream(filename);
                    cu = JavaParser.parse(in);
            }
            catch(ParseException x)
            {
                 // handle parse exceptions here.
            }
            finally
            {
                  in.close();
            }
            return cu;