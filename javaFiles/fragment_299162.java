Map<File, File> existingFiles = new Map<File, File>();
for (File f : filesInCabinet) {
   existingFiles.put(f, f);
}

for (File f : filesInCabinet) {
   List<File> relatedFiles = f.getRelatedFiles();
   for (int i = 0; i < relatedFiles.size(); i++) {
      File relatedFile = existingFiles.get(relatedFiles.get(i));
      relatedFiles.set(i, relatedFile);
   }
}