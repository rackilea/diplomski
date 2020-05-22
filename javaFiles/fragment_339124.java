public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException 
            {
                if (matcher.matches(file))
                {
                    files.add(file.toFile());
//'files.add(file.toString());' changed
                }//end if(matcher)