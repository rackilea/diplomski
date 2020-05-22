final int nTabIndex = myTabbedPane.indexOfTabComponent( myPanel );
final boolean bIsVisible = myTabbedPane.isEnabledAt( nTabIndex );
if ( bIsVisible ) {
    // Do stuff with myPanel
    myPanel.repaint();
}