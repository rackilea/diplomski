public void methodA(File file) throws CustomUserInputException {
  try {
  }
  catch (IOException ex) {
    throw new CustomUserInputException(ex, "Error opening file" + file.getPath());
  }
}