public class FileNameComparator implements Comparator<File> {
    public int compare( File a, File b ) {
        return a.getName().compareTo( b.getName() );
    }
}

public class FileSizeComparator implements Comparator<File> {
    public int compare( File a, File b ) {
        int aSize = a.getSize();
        int bSize = b.getSize();
        if ( aSize == bSize ) {
            return 0;
        }
        else {
            return Integer.compare(aSize, bSize);
        }
    }
}

...