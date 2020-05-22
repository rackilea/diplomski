protected void main(){
    Intent i = new Intent("android.intent.action.MainActivity");
    startActivity(i);
}
protected void sign_up(View view){
if(view.getId()==R.id.button2){
    Intent i = new Intent("android.intent.action.sign_up");
    startActivity(i);
}
}