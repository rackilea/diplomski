String findFileName(String containerName, String path){
    int counter=0;
    String [] sa = path.split("\\\\");
    String res="";

    for(int i=0; i<sa.length; i++)
    {

        if(counter==3)
           res+=sa[i]+" ";
        if(sa[i].equals(containerName))
            counter++;
        if(counter==3)
           res+=sa[i]+" ";
    }

    return res.trim();
}