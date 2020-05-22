JFileChooser chooser = new JFileChooser();
setWindowsPlacesBackground( chooser );

private void setWindowsPlacesBackground( Container con ) {
  Component[] jc = con.getComponents();
  for( int i = 0; i < jc.length; i++ ) {
    Component c = jc[i];
    if( c instanceof WindowsPlacesBar ) {
      ((WindowsPlacesBar) c).putClientProperty("XPStyle.subAppName", null);
      return;
    }
    if( c instanceof Container ) {
      setWindowsPlacesBackground( (Container)c );
    }
  }
}