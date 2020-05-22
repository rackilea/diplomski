public int compare(FileItem o1, FileItem o2) 
{
    if (o1 == null) {
        if (o2 == null) {
            return 0;
        } else {
            return 1; // this will put null in the end
        }
    } else if (o2 == null) {
        return -1;
    }
    String n1 = o1.getFileName();
    String n2 = o2.getFileName();
    if (n1 == null) {
        if (n2 == null) {
            return 0;
        } else {
            return 1; // this will put null names after non null names 
        }
    } else if (n2 == null) {
        return -1;
    }
    return n1.compareTo(n2);
}