static public int readFully(InputStream inp, byte[] arr, int ofs, int len) throws IOException {
    int                                 rmn,cnt;

    for(rmn=len; rmn>0; ofs+=cnt, rmn-=cnt) {
        if((cnt=inp.read(arr,ofs,rmn))==-1) { 
            throw new IOException("End of stream encountered before reading at least "+len+" bytes from input stream"); 
            }
        }
    return len;
    }