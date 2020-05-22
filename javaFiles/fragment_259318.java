private void setColumnWidth ( TableColumn column, double targetWidth ) {
    try {
        Method method = TableColumnBase.class.getDeclaredMethod( "doSetWidth", double.class );
        method.setAccessible( true );
        method.invoke( column, targetWidth );
    } catch ( NoSuchMethodException | InvocationTargetException | IllegalAccessException e ) {
        e.printStackTrace();
    }
}