File file = new File(<path to directory>);
BufferedWriter dBufferedWriter = new BufferedWriter(new FileWriter(file));
try{        
    // some code where you can get exception

    String str = "some string or null if error occurs";
    dBufferedWriter.write(str);     
}finally{
    dBufferedWriter.close();
    if(file.length()==0) file.delete();
}