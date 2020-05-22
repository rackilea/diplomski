String files[] = dir.list();

for (int i = 0; i < files.length; i++) {
    File tmp = new File(files[i]);
    data.add(new Object[] { tmp.getAbsolutePath()}) ;           
}