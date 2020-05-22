int r = random.nextInt(4);
if(r==0){
mp.start();
Toast.makeText(getApplicationContext(), "Hmm Busy I Am", Toast.LENGTH_LONG).show();
} 
if(r==1){
mp1.start();
Toast.makeText(getApplicationContext(), "I'm hungry", Toast.LENGTH_LONG).show();
} 
if(r==2){
mp2.start();
Toast.makeText(getApplicationContext(), "My droid now", Toast.LENGTH_LONG).show();
} 
if(r==3){
mp3.start();
Toast.makeText(getApplicationContext(), "Not droid you are looking for", Toast.LENGTH_LONG).show();
}