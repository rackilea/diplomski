public static void addManyMouseListeners( Component component, MouseListener... mouseListeners ) {

    if ( component != null && mouseListeners != null ) {
        for ( MouseListener mouseListener : mouseListeners ) {
            component.addMouseListener( mouseListener );
        }
    }
}