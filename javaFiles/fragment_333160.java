public String getMimeType(String name) {
    if (name.endsWith(".jad")) {  
        return "text/vnd.sun.j2me.app-descriptor";  
    } else if (name.endsWith(".cod")) {  
     return "application/vnd.rim.cod";  
    } else {  
        return null;  
    }  
}