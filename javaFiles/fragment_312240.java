// Display a frame with HTML code
public JFrame displayHTMLJFrame(String HTML, String title){
        JFrame fen = new JFrame();
    fen.setSize(1000, 800);
    fen.setTitle(title);

    JEditorPane pan = new JEditorPane();
    pan.setEditorKit(new HTMLEditorKit());
    pan.setEditable(false);

    pan.setText(HTML);
    fen.add(pan);
    return fen;
}