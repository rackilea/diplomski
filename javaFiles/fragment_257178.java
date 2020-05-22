public void forEveryChildOf(File file) {
    for(File child:file.listFiles())
        doForEach(file,child);
}

private void doForEach(File topParent,File child){
    if(child.isFile())
        System.out.println("Do logic");

    if(child.isDirectory())
        for(File subchild:child.listFiles())
            doForEach(topParent,subchild);
}