public Editor(FileContentSubject filecontentsubject) {
    super("Editor");
    initComponents();

    this.reference = filecontentsubject;
    textArea.getDocument().addDocumentListener(reference);
    textArea.getDocument().putProperty("ownerEditor", this); // <---- ADDED LINE
}