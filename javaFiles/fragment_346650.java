public FileDetails getMaxLastModified(List<FileDetails> fileDetails) {


     FileDetails[] files = (FileDetails[]) fileDetails.toArray(new FileDetails[fileDetails.size()]);

     Arrays.sort(files,  FileDetailComparator);

    return files[0];
}



public static Comparator<FileDetails> FileDetailComparator = new Comparator<FileDetails>() {

    public int compare(FileDetails f1, FileDetails f2) {
                    //For descending
                   return f2.getDate().compareTo(f1.getDate());

                   //For ascending
                   //return f1.getDate().compareTo(f2.getDate());

    }

};