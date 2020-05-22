public void signup(){
    Intent intent  = new Intent(SignUp.this,finalactivity.class );
    intent.putExtra("name", name);//name you get from EditText
    intent.putExtra("email", email);//emailyou get from EditText
    startActivity( intent );  
}