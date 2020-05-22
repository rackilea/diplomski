File serverFile = new File(dir.getAbsolutePath() + File.separator + stringDate+"_"+nameZipFile+".zip");
FileOutputStream fileOutputStream = new FileOutputStream(serverFile);
ZipArchiveOutputStream zos = new ZipArchiveOutputStream(fileOutputStream);
for (Tree<FileableCmisObject> aList : sitoFolderDescendants) {
   traverseTree(aList, zos, reportDocument);
}
zos.close();