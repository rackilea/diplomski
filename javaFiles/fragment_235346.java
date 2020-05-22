@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent 
        data {
    super.onActivityResult(requestCode, resultCode, data);  
    switch(requestCode){  
        case 100:  
            stringaA.setText(data.getStringExtra("stringaA"));  
            break;  
        case 101:  
            numeroB.setText(data.getStringExtra("numero"));  
            break;  
    }
}