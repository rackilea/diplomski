@Override
public void onPause(){

    super.onPause();

    if(pDialog != null){
        pDialog.dismiss();
    }        

    ...

}