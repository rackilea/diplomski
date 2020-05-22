@Override
protected void onPrepareDialog ( int id, Dialog dialog ) {
    switch ( id ) {
        case RESULT_DIALOG:
            AlertDialog alertDialog = ( AlertDialog ) dialog;
            alertDialog.setMessage( localTv.getText() );
            break;
    }
    super.onPrepareDialog( id, dialog );
}