public String getNewFileID(Drive service, String oldSpreadsheetsKeyID){
   File file = service.files().get(oldSpreadsheetsKeyID).execute()
   String alternateLink = file.getAlternateLink();

   String[] aux1 = alternateLink.split("/spreadsheets/d/");         
   String[] aux2 = aux1[1].split("/edit?");

   String newFileID = aux2[0];

   return newFileID;
}