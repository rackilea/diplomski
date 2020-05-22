public void onItemClick(){ 
    Intent in = new Intent();
    weaponID = position  + 1;
    in.putExtra("test", "test");
    setResult(726,in);
    finish();
}