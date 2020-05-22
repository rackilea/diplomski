public String getOS() {
    String os = System.getProperty("os.name").toLowerCase();

    if(os.indexOf("mac") >= 0){
       return "MAC";
    }
    else if(os.indexOf("win") >= 0){
       return "WIN";
    }
    else if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0){
       return "LINUX/UNIX";
    }
    else if(os.indexOf("sunos") >= 0){
       return "SOLARIS";
    }