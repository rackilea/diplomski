@Override
public void actionPerformed(ActionEvent e) {

    TopComponent tcArray[] = WindowManager.getDefault().findMode("editor").getTopComponents();
    for (TopComponent tc : tcArray) {
        System.out.println("tc = " + tc);

        if (null != tc && null != tc.getDisplayName()
                && tc.getDisplayName().equals("test.java")) {
            Collection<? extends FileObject> fileobjs = tc.getLookup().lookupAll(FileObject.class);
            for (FileObject fo : fileobjs) {
                try {
                    String text = fo.asText();
                    System.out.println("text = " + text);
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
    }
}