void RecursiveFileSearch(File f, String d) {
    int i;
    String s[] = f.list();
    for (i = 0; i < s.length; i++) {
        File fs = new File(d + "/" + s[i]);
        if (fs.isDirectory()) {
            System.out.println("#DIRECTORY :"+s[i]);
            String d2 = d + "/" + s[i];
            RecursiveFileSearch(fs, d2);
        } else {

            System.out.println("@FILE : "+s[i]);
        }

    }
}