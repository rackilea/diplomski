Folder fold = Factory.Folder.fetchInstance(os, folderPath, null);
        DocumentSet docs = fold.get_ContainedDocuments();
        Iterator it = docs.iterator();

        Document retr;
        try {
            while (it.hasNext()) {
                retr = (Document)it.next();
                String name = retr.get_Name();
                System.out.println(name);

                if(name.equals(fileName)) {

                    System.out.println("Match Found");
                    System.out.println("Document Name : " + retr.get_Name());
//here you are checking the document for the name. It also can happen that, this document might have more than version but the title remained same for each version. You can get the latest version like

                    return retr.get_CurrentVersion();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }