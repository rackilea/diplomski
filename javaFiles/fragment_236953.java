Action.java
    -----------
    buildFile() { 
    //build file/writes in the file
      Servlet servlet = new Servlet();
      servlet.doget();
    }

    Servlet.java
    -----------
    doget(){
    //gets the file from the server
    }  

<input type="button" class="button" value="Download" onclick="build();"/>