startActivityForResult(intent, 11);

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data){
    if(requestCode == 11){
        if(resultCode == 200){
            saveWaiver();
        }
    }else{
        super.onActivityResult(requestCode, resultCode, data)
    }
}