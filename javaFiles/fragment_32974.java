try {
        while( true )
        {
            String ID = in.readUTF();
            String Name = in.readUTF();
            System.out.println(ID + " " + Name);
        }
     } catch( EOFException eof ){
        // handle regular end of file
     } catch( IOException ioe ){
        // error
     } catch( UTFDataFormatException dfe ){
        // error
     }