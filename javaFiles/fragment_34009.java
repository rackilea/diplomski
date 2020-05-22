@ActionID(category = "Edit", id = "com.beg.regextester.RegexTesterListener")
@ActionRegistration(displayName = "Regex Tester")
@ActionReference(path = "Editors/text/x-java/Popup")
public class RegexTesterListener implements ActionListener {

    private final DataObject context;

    public RegexTesterListener(DataObject context) {
        this.context = context;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Identify java object in the context
        FileObject fileObject = context.getPrimaryFile();
        JavaSource javaSrc = JavaSource.forFileObject(fileObject);
        if (javaSrc == null) {
           StatusDisplayer.getDefault().setStatusText(fileObject.getPath() + " is not a java file");
    } else {
        try {
            javaSrc.runUserActionTask(new org.netbeans.api.java.source.Task<CompilationController>() {

                @Override
                public void run(CompilationController p) throws Exception {
                    p.toPhase(JavaSource.Phase.ELEMENTS_RESOLVED);
                    Document doc = p.getDocument();
                    if (doc == null) {
                        StatusDisplayer.getDefault().setStatusText("Java file is closed");
                    } else {
                        new MemberVisitor(p).scan(p.getCompilationUnit(), null);
                    }
                }
            }, true);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//end else
    }//end actionPerformed

    private static class MemberVisitor extends TreePathScanner<Void, Void> {

    private CompilationInfo info;

    public MemberVisitor(CompilationInfo info) {
        this.info = info;
    }

    @Override
    public Void visitClass(ClassTree t, Void v) {
        try {
            JTextComponent editor = EditorRegistry.lastFocusedComponent();

            if (editor.getDocument() == info.getDocument()) {
                int dot = editor.getCaret().getDot();

                TreePath tp = info.getTreeUtilities().pathFor(dot);
                Element el = info.getTrees().getElement(tp);
                if (el != null) {
                    StatusDisplayer.getDefault().setStatusText("Please, select a string");
                } else {
                        //get the selected text
                        String str = editor.getSelectedText();
                        //process the string and pass it to the clipboard
                        ...
                        //replacing the old str by the new one
                        editor.paste(); 


                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return null;
    }

}
}//end class