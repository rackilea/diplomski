public void jTree1ValueChanged( TreeSelectionEvent tse ) {
     String node = tse.getNewLeadSelectionPath().getLastPathComponent().toString();
    if( node.equals("audio") ) {
        // play audio
    } else if( node.equals("video") ) {
       // play video
    }
}