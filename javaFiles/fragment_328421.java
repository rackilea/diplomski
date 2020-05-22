int option = CANCEL_OPTION;
boolean fileIsValid = false;
do {
 option = filechooser.showOpenDialog(); //or save?
 if( option == OK_OPTION ) {
    fileIsValid = isValid( filechooser.getSelectedFile()); //implementation of isValid() is left for you
 }
} while( option == OK_OPTION && !fileIsValid);