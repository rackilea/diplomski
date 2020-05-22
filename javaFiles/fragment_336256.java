public Date getDateAssociatedWithFileRevision(String [] filePath, int revisionNumber) {

        List<IFileSpec> fileList = null;
        Map<IFileSpec,List<IFileRevisionData>> fileRevisionData = null;
        String currentFile = null;
        Date revisionDate = null;

        try 
        {
            String file = filePath[0] + "#" + revisionNumber;
            currentFile = file;
            fileList = getIFileSpecList(file);  //Get list of file(s) in path

            for(IFileSpec fileSpec: fileList)
            {
                if(file.toString() == null)
                {
                    System.out.println("\"" + currentFile +"\"" + " does not exist...");
                    break;
                }
                fileRevisionData = fileSpec.getRevisionHistory(0, true,false,true,false);
                for(List<IFileRevisionData> revisionData : fileRevisionData.values()) {
                    int revision = revisionData.get(0).getRevision();
     -------------> if(revision.equals(revisionNumber))
                    {
                        revisionDate = revisionData.get(0).getDate();

                        System.out.println("Rev number: " +revision +" :: " + "Revision Date: " + revisionDate);
                        break;

                    }
                }

            }
        }
        catch(Exception e){e.printStackTrace();}
        return revisionDate;  
     }