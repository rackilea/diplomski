while( true ) {
    String value = JOptionPane.showInputDialog( "Enter a number or -1 to stop" );
    System.out.println( value );
    if ( "-1".equals(value) ) {
        break;
    }
}