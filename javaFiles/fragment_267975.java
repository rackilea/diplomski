String line;

do{ line = br.readLine(); }
while( null != line && !line.equals("Start"));

if ( line.equals("Start") ) { // in case of EOF before "Start" we have to skip the rest!
    do{ 
        line = br.readLine(); 
        if ( line.equals("End") ) break;
        // TODO write to other file
    }while(null != line )
}