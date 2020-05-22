File dir = new File("");
System.out.println(dir.getAbsolutePath()+" | "+dir.isDirectory()+" | "+dir.exists());
System.out.println("file name is: |" + dir.getName() + "|");
String absolutePathname = dir.getAbsolutePath();
dir = new File(absolutePathname);**
System.out.println(dir.getAbsolutePath()+" | "+dir.isDirectory()+" | "+dir.exists());
System.out.println("file name is: |" + dir.getName() + "|");