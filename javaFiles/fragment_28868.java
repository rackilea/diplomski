ArrayList<SmbFile>  readFiles = readFolder?.listFiles()
    for(file in readFiles ){
String name = file.properties.getKey("name")
destinationFolder = new SmbFile(foldersInfo?.destinationFolder+"/"+name,auth)
                    destinationFolder.createNewFile()
                    file.copyTo(destinationFolder)

        }