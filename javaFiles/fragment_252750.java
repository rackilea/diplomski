static final List<String> EXTENSIONS = ImmutableList.of("nfo", "sfv", "srr", "nzb", "srt");
final Ordering<String> fileNameOrdering = new Ordering<String>() {
  public int compare(String a, String b) {
    String extA = Files.getFileExtension(a);
    String extB = Files.getFileExtension(b);
    int extAIndex = EXTENSIONS.indexOf(extA);
    int extBIndex = EXTENSIONS.indexOf(extB);
    if ((extAIndex >= 0) == (extBIndex >= 0)) { // if they are both known extensions or both unknown
      return extAIndex - extBIndex;
    } else if (extAIndex < 0) { // a is unknown, b is known
      return -1;
    } else if (extBIndex < 0) { // b is unknown, a is known
      return 1;
    }
    return a.compareTo(b);
  }
}.nullsLast();
return new Ordering<NzbFile>() {
  public int compare(NzbFile a, NzbFile b) {
    return ComparisonChain.start()
      .compare(a.getFileName(), b.getFileName(), fileNameOrdering)
      .compare(a.getSubject(), b.getSubject())
      .result();
  }
};