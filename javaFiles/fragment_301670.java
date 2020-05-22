public void Picture(int i){

View k = new View(NewGame.this);

setContentView(k);

int resourceId=getResources().getIdentifier("pic"+i, "drawable",getPackageName()); 

k.setBackgroundResource(resourceId);
}