File dir = new File("DIR");
dir.mkdir();
File file1 = new File(dir,"myfile1.txt");
file1.createNewFile();
File file2 = new File(dir,"myfile2.txt");
file2.createNewFile();