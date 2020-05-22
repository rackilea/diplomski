public void Imagen(){

int im = ImageChooser.showOpenDialog(ImageChooser);
    if (im == JFileChooser.APPROVE_OPTION){
        System.out.println("Loading Image...");
        int caretPos = EditorPane.getCaretPosition();
        HTMLEditorKit e = new HTMLEditorKit();
     try {


    String Path = String.format( ImageChooser.getSelectedFile().getAbsolutePath());
               System.out.println(Path);
         e.insertHTML(document, caretPos,"<img src=\"file:\\"+Path+"\" alt=\"some_text\">" , 0, 0, HTML.Tag.IMG);
       //  <img src="url" alt="some_text">

     } catch (BadLocationException ex) {
         Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
     }


        }else{
            System.out.println("Nothing loaded");}
}