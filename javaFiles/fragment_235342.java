private List<Folder> folderList=new ArrayList<>();
private String trackMsg="";//to show tracks of the path:  root>me>inme

@PostConstruct
public void init(){//Just initialize thr list
    folderList.add(new Folder("root", 0, 0));
    folderList.add(new Folder("me", 1, 0));
    folderList.add(new Folder("folder", 2, 0));
    folderList.add(new Folder("inme", 3, 1));
    folderList.add(new Folder("ininme", 4, 3));
}

public void track(int id){//to composite the track path
    trackMsg="";
    Folder selectedFolder=new Folder();
    for(Folder fold:folderList) //find the selected Folder
        if(fold.getId()==id)
        {
            selectedFolder=fold;
            if(selectedFolder.getId()!=selectedFolder.getRef())//if so, it means the root folder
            trackMsg=">"+selectedFolder.getName();
        }

    Folder parentFolder=findParent(selectedFolder);//get the parent folder of the selected folder

    while(parentFolder!=null && parentFolder.getId()!=parentFolder.getRef()){//while there is parent folder and not root folder
        trackMsg=">"+parentFolder.getName() + trackMsg;
        parentFolder=findParent(parentFolder);//find the parent of parent
    }

    trackMsg="root"+trackMsg;//the last, root folder
}

public Folder findParent(Folder child){//find the parent folder of the passing folder
    for(Folder fold:folderList)
        if(fold.getId()==child.getRef())
            return fold;
    return null;
}