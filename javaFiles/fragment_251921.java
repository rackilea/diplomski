public static void main( String[] args ) {
  EventQueue.invokeLater( new Runnable() {
    @Override
    public void run() {
      JFileChooser chooser = new JFileChooser(  );
      chooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
      chooser.showSaveDialog( null );
      System.out.println( chooser.getSelectedFile() );
    }
  } );
}