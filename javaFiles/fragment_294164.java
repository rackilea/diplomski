File tmp = new File( "/tmp");
        List<String> fileList = new ArrayList<String>();
        if( tmp.isDirectory())
        {
            for( File f : tmp.listFiles())
            {
                if( f.isFile() )
                {
                    if((f.getName().endsWith( ".dat") || f.getName().endsWith(".DAT")))
                    {
                        fileList.add( f.getName() );
                    }
                }
            }

            for( String fileName : fileList)
            {
                System.out.println( fileName);
            }
        }