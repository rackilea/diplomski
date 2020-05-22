public void importFix() {
       JavaFixAllImports fiximports = JavaFixAllImports.getDefault();
       jtc = EditorRegistry.lastFocusedComponent();
       FileObject fo = FileUtil.toFileObject(new File("path of the .java file"));
       fiximports.fixAllImports(fo, jtc);
   }