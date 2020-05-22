public void replacePassword(String newPass, String oldPass, String destFile) throws IOException
{

    Path filePath = Paths.get(destFile);
    String fileContent = new String(Files.readAllBytes(filePath));
    //System.out.println(fileContent);
    //Here you use replace method not replaceAll!
    fileContent = fileContent.replace(Matcher.quoteReplacement(oldPass), Matcher.quoteReplacement(newPass));
    //System.out.println(fileContent);
    Files.write(filePath, fileContent.getBytes());

}