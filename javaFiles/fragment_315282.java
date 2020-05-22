public class Utils {
  /**
   * Empty and delete a folder (and subfolders).
   * @param folder
   *            folder to empty
   */
  public static void rmdir(final File folder) {
      // check if folder file is a real folder
      if (folder.isDirectory()) {
          File[] list = folder.listFiles();
          if (list != null) {
              for (int i = 0; i < list.length; i++) {
                  File tmpF = list[i];
                  if (tmpF.isDirectory()) {
                      rmdir(tmpF);
                  }
                  tmpF.delete();
              }
          }
          if (!folder.delete()) {
            System.out.println("can't delete folder : " + folder);
          }
      }
  }
}