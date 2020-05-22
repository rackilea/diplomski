public static void main ( String[] args ) throws Exception {
    classModel model = new classModel();
    classView view = new classView( model );
    new classController( model, view );
    view.setVisible( true );
}