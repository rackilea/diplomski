boolean status = false;

@Override
public void onUpdateAlert(final int event, final String message){
    status = true;    
    // pop up the dialog
}

@Override
public void onDetected(Hand pose){
    if(status) {
            status = false;
            ...          
    }
}