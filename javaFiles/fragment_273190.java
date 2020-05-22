class PDFFrame extends JInternalFrame {
    private PDFJPanel panel;

    public PDFFrame(File file) {
        panel = new PDFJPanel(file); 
        add(panel, BorderLayout.CENTER);
    }

    public void setDefaultColor(Color c){
        panel.setDefaultColor();
    }
}