private final File file;

public ContactStore(Context context) {
  super();
  String root = context.getFilesDir();
  file = new File(root + File.separator + "Contacts.txt");
}