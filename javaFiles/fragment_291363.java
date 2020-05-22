public static MyFolder readFiles(File file,List<MyFolder> myfolder,MyFolder childObj)
    {
        try
        {
            List<MyFolder> childArray = new ArrayList<MyFolder>();
            if(file.isDirectory())
            {
                File[] file_array = file.listFiles();
                if(file_array.length == 0 ){
                    childObj.text = file.getAbsolutePath();
                    myfolder.add(childObj);
                    childObj = new MyFolder();
                }else{
                    childObj.text = file.getAbsolutePath();
                    childArray = childObj.nodes;
                    if(childArray == null)
                        childArray = new ArrayList<MyFolder>();
                }
                for(File tempFile : file_array)
                {
                    if(tempFile.isDirectory())
                    {
                        childObj = readFiles(tempFile,myfolder,childObj);
                        if(childObj.text != null)
                            myfolder.add(childObj);
                        childObj = new MyFolder();
                    }
                    else
                    {
                        MyFolder obj = new MyFolder();
                        obj.text = tempFile.getAbsolutePath();
                        childArray.add(obj);
                    }
                }
                childObj.nodes = childArray;
            }
            else
            {
                childObj.text = file.getAbsolutePath();
                myfolder.add(childObj);
                childObj = new MyFolder();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return childObj;
    }