for ( File f : contents)
{
    currentFile = f.getAbsolutePath();
    currentFile = currentFile.replace("[the path]", "");
    System.out.println(currentFile);
}