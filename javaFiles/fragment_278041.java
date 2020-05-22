TableItem item = table.getSelection()[ 0 ]; // assumes a single selected item
item.setText( 1, "update first column" );
// or
item.setText( new String[]{ "col 1 value", "col 2 value" } );
// or, for a single-columned table
item.setText( "updated value" );