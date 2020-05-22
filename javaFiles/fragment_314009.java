NoteCollection nc = database.createNoteCollection(false);
nc.setSelectFolders(true);
nc.buildCollection();
String id = nc.getFirstNoteID();
while (id.length() > 0) {
  String strFolderName = ""
  Document docFolder = database.getDocumentByID(strFolderId);
  strFolderName = docFolder.getItemValueString("$Title");
  if (strFolderName.startsWith(prefix)) {
     ....
  }
}