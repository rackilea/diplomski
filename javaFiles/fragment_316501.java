import com.enterprisedt.net.ftp.FTPFile;
...
public static void main(String[] args) throws Exception {
    // create an array of dummy files
    Calendar cal = GregorianCalendar.getInstance();
    FTPFile[] ftpfiles = new FTPFile[5];
    cal.set(Calendar.SECOND, 1);
    ftpfiles[0] = new FTPFile("raw", "file1", 111, false, cal.getTime());
    cal.set(Calendar.SECOND, 5);
    ftpfiles[1] = new FTPFile("raw", "file5", 555, false, cal.getTime());
    cal.set(Calendar.SECOND, 3);
    ftpfiles[2] = new FTPFile("raw", "file3", 333, false, cal.getTime());
    cal.set(Calendar.SECOND, 4);
    ftpfiles[3] = new FTPFile("raw", "file4", 444, false, cal.getTime());
    cal.set(Calendar.SECOND, 2);
    ftpfiles[4] = new FTPFile("raw", "file2", 222, false, cal.getTime());

    System.out.println("unsorted file list");
    for (FTPFile ftpfile : ftpfiles) {
        printFileInfo(ftpfile);
    }

    // sort array by last modification time in descending order
    Arrays.sort(ftpfiles, new Comparator<FTPFile>() {
        @Override
        public int compare(FTPFile o1, FTPFile o2) {
            return o2.lastModified().compareTo(o1.lastModified());
        }
    });

    System.out.println("sorted file list");
    for (FTPFile ftpfile : ftpfiles) {
        printFileInfo(ftpfile);
    }

    System.out.println("the three recent files only");
    for (int i = 0; i < 3; i++) {
        printFileInfo(ftpfiles[i]);
    }

}

static void printFileInfo(FTPFile ftpfile) {
    System.out.printf("name: %s  mtime: %s  size: %d%n",
            ftpfile.getName(),
            ftpfile.lastModified(),
            ftpfile.size()
    );
}