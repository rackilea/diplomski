if
{
  ...
}

String files[] = srcFolder.list();
for (String file : files)
{
    File srcFile = new File(srcFolder, file);
    File destFile = new File(destDirectory, file);
    //recursive copy
    makeCopies(srcFolder, destDirectory);
}

else
{
  ...
}