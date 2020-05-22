private final void getFilePath(ResponseFiles fileToGet) {
    String packagePath = "/com/knockknock/message";

    if (fileToGet == ResponseFiles.CLUES)
        file = new File(getClass().getResource(
                String.format("%s/clues.txt", packagePath)).getPath());
    else if (fileToGet == ResponseFiles.ANSWERS)
        file = new File(getClass().getResource(
                String.format("%s/answers.txt", packagePath)).getPath());
}