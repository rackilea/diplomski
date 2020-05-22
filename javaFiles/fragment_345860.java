public class NewestFileOnlyFilter implements FileListFilter<FTPFile> {

  @Override
  public List<FTPFile> filterFiles(FTPFile[] files) {
    return Arrays.stream(files)                                         // 1
                 .max(Comparator.comparing(FTPFile::getTimestamp))      // 2
                 .map(Collections::singletonList)                       // 3
                 .orElse(Collections.emptyList());                      // 4
  }
}