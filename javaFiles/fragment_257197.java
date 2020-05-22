try ( Scanner fin = new Scanner ( new File(codeFile) ); ) 
    {
     for (int i = 0; i < CONSTANT - 1 && fin.hasNext(); i++) 
          {
          Arrays[i] = fin.next();
          }
    }
    catch (FileNotFoundException e) 
    {
        System.err.println( "Read Error: " + e.getMessage() );
    }