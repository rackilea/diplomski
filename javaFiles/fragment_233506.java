DefaultComboBoxModel dcm = new DefaultComboBoxModel();
combo.setModel( dcm );
....
for( String newRow : dataFetched ) {
    dcm.addElement( newRow )
}