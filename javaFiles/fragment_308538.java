private void copyFile(File inputPath, File outputPath){
 try (FileOutputStream fos = new FileOutputStream(outputPath)) {

     Files.copy(inputPath.toPath(), fos);
     Log.d("Copied file to ", outputPath.toString());

  } catch (FileNotFoundException fnfe1) {
     Log.d("Tag",fnfe1.getMessage());
  } catch (Exception e) {
     Log.d("tag", e.getMessage());
  }
}