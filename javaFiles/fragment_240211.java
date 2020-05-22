@Override
protected void onPause() {    
    super.onPause();          
    if(isFinishing()) listActivityDone = true;      
}

@Override
protected void onResume() {    
    super.onResume();          
    if(!isFinishing()) listActivityDone = false;      
}