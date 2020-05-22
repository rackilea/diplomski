boolean editDefaultApplication(){
    AssociationService serv = new AssociationService();

    //try to remove old association
    Association logassoc = serv.getFileExtensionAssociation(".mp3");       

    try {
        serv.unregisterUserAssociation(logassoc);
    } catch (java.lang.IllegalArgumentException |  AssociationNotRegisteredException | RegisterFailedException e) {
         e.printStackTrace();
         return false;
    }

    //add your own application as default
    logassoc.addFileExtension(".mp3");
    logassoc.addAction(new org.jdesktop.jdic.filetypes.Action("open", "<path to wrapper executable>"));
    try {
        serv.registerUserAssociation(logassoc);
    } catch (java.lang.IllegalArgumentException |  AssociationNotRegisteredException | RegisterFailedException e) {
         e.printStackTrace();
         return false;
    }

    return true;
}