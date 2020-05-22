public boolean contains(FileCollection other) {
    Comparator<File> comparator = new Comparator<File>() {
        @Override
        public int compare(File lhs, File rhs) {
            int cmp = lhs.getBase().compareToIgnoreCase(rhs.getBase());
            if (cmp == 0) {
               cmp = lhs.getExtension().compareToIgnoreCase(rhs.getExtension());
            }
            if (cmp == 0) {
               cmp = Long.compare(lhs.getSize(), rhs.getSize());
            }
            if (cmp == 0) {
               cmp = Long.compare(lhs.getPermissions(), rhs.getPermissions());
            }
            return cmp;
        }
    };
    Arrays.sort(this.files, comparator);
    Arrays.sort(other.files, comparator); //THIS AND THE COMPARATOR SORT THE ARRAYS BASED ON ALL FILE ATTRIBUTES    
    int i = 0;
    int j = 0;
    if (this.files.length<other.files.length)
        return false;
    while (i<other.files.length && j<this.files.length) {
        if (!(this.files[j].equals(other.files[i])))
            j++;
        else {
            j++;
            i++;
        }
    }
    if (i<other.files.length)
        return false;
    else
        return true; 
}