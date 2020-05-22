public void moveToDir(String workDir, String moveDir) {
  for (File file : new File(workDir).listFiles()) {
      System.out.println(file.getName());
      final File toFile = new File(moveDir, file.getName());
      if (toFile.exists() && !toFile.delete())
        throw new RuntimeException("Cannot delete " + toFile);
      System.out.println(toFile);
      if (!file.renameTo(toFile))
        throw new RuntimeException(
          "Can't move file to " + moveDir +": " + file.getPath());
  }
}