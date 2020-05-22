private void updateLabel() {
   StringBuilder text = new StringBuilder();
   //this assumes listModel is a DefaultListModel and doesn't contain null values
   //adapt for other list models and add any necessary checks
   for( Object entry : listModel.toArray() ) {
     text.append( entry.toString()).append(" ");
   }
   label.setText( text.toString() );
}