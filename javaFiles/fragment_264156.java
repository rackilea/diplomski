public class Zipper {

private static String NO_ZIP_MESSAGE = "";
// private static String NO_ZIP_MESSAGE = " (no zip)";

public static void main(String[] args) {
    new Zipper().go("C:/temp/zipper");
}

private void go(String startingFolderStr) {
    MyFile startingFolder = new MyFile(new File(startingFolderStr), false);
    boolean zipStartingFolder = recurse(startingFolder, "");
    System.out.println("------------------ " + zipStartingFolder);
    cleanup(startingFolder, "", false);
}

private boolean recurse(MyFile folder, String indent) {

    // Go through the folder structure top-down and check if individual files meet the criteria, and also update zip
    // flag for folders in "direct descendance".

    System.out.println(indent + folder.file.getName());
    boolean allSiblingsMeetCriteria = true;
    for (File f : folder.file.listFiles()) {
        MyFile mf = new MyFile(f, false);
        folder.siblings.add(mf);
        if (f.isFile()) {
            boolean meetsCriteria = f.getName().startsWith("m");
            mf.zip = !meetsCriteria;
            allSiblingsMeetCriteria = allSiblingsMeetCriteria && meetsCriteria;
            System.out.println(indent + "      " + f.getName() + (meetsCriteria ? "" : " --> ZIP"));
        } else if (f.isDirectory()) {
            allSiblingsMeetCriteria = recurse(mf, indent + "  ") && allSiblingsMeetCriteria;
        }
    }
    folder.zip = allSiblingsMeetCriteria;
    System.out.println(
            indent + "... " + folder.file.getName() + (allSiblingsMeetCriteria ? " --> ZIP" : NO_ZIP_MESSAGE));
    return allSiblingsMeetCriteria;
}

private void cleanup(MyFile folder, String indent, boolean parentIsZipped) {

    // If we come to a folder with zip=true, all its subfolders have zip=true and all its subfiles have zip=false.
    // Set parentIsZipped=true, and go thru and set all subfolders to zip=false (1). Ignore subfiles since they are
    // already ok.

    // If we come to a folder with zip=false (and we're not in a 'true flow' (comment above)), all subfiles should
    // have zip=true (2), but we leave subfolders as is

    System.out.println(indent + folder.file.getName() + (folder.zip ? " --> ZIP" : NO_ZIP_MESSAGE));
    parentIsZipped = parentIsZipped || folder.zip;
    for (MyFile mf : folder.siblings) {
        if (mf.file.isFile()) {
            if (!parentIsZipped) {
                mf.zip = true; // (2)
            }
            System.out.println(indent + "      " + mf.file.getName() + (mf.zip ? " --> ZIP" : NO_ZIP_MESSAGE));
        } else if (mf.file.isDirectory()) {
            if (parentIsZipped) {
                mf.zip = false; // (1)
            }
            cleanup(mf, indent + "  ", parentIsZipped);
        }
    }
}

private class MyFile {

    File file;
    boolean zip;
    List<MyFile> siblings;

    public MyFile(File file, boolean zip) {
        this.file = file;
        this.zip = zip;
        siblings = new ArrayList<>();
    }
}

}