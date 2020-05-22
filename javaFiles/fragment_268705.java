if(i==3){
    Intent intent = new Intent(getApplicationContext(), MainMenu.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

    startActivity(intent);
    startActivity(new Intent(MagicPower.this,MainMenu.class));

    running=false;
    finish();
    break;
}