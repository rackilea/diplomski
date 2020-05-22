try { 
    // ...
} finally {
    a.close
    if(bw != null) bw.close     // close and flush
}