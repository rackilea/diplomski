String FolderName="C:/name";//Write your complete path here
try {
       Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + FolderName);
    } catch (IOException ex) {
             Logger.getLogger(ClassName.class.getName()).log(Level.SEVERE, null, ex);
    }