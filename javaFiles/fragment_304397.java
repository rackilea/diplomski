BufferedReader reader = null;
try {
    // do stuff
} catch(IOException e) {
    // handle 
} finally {
    if(reader != null) {
        try {
            reader.close();
        } catch(IOException e1) {
            // handle or forget about it
        }
    }
}