class FileWriterExample {
    FileWriter writer1 = new FileWriter(new File(path1));
    FileWriter writer2 = new FileWriter(new File(path2));

    //You can write to any of those indiferently
    //just remember to close them
    try {

    }finally{
        if(writer1 != null){
            writer1.flush();
            writer1.close();
        }
        if(writer2 != null){
            writer2.flush();
            writer2.close();
        }
    }
}