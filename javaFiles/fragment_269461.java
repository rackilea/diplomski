if (listOfFiles[i].isFile())
{
    String fileName = listOfFiles[i].getName();
    System.out.println(fileName);
    doesFileExistInDb(fileName);
}