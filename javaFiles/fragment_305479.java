try{
        ...

        FileHandler fh = new FileHandler("/Users/me/.jenkins/myLogs");
        ...

    } catch (java.io.IOException e){
        //handle exception
    }