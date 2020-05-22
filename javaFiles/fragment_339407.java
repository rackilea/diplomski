InputStream stream = new FileInputStream("in");
    try { //no operations between open stream and try block
        //work
    } finally { //do nothing but close this one stream in the finally
        stream.close();
    }