Comparator<File> comparator = new Comparator<File>() {
  @Override
  public int compare(File o1, File o2) {
    /*
     * Here, compare your two files with your own algorithm.
     * Here is an example without any check/exception catch
     */
    String from1 = o1.getName().split("-")[0]; //For '1-5', it will return '1' 
    String from2 = o2.getName().split("-")[0]; //For '11-20', it will return '11'

    //Convert to Integer then compare : 
    return Integer.parseInt(from2)-Integer.parseInt(from1);
  }
}

//Then use your comparator to sort the files:
Arrays.sort(dirList, comparator);