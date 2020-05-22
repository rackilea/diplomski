File f = new File("folder");
FilenameFilter f2 = new FilenameFilter() {
public boolean accept(File dir, String filename) {
return filename.endsWith("zip");
}
};
if (f.list(f2).length > 0) {
// there's a zip file in there..
}