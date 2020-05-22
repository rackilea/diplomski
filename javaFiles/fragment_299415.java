void myanimation(){
TranslateAnimation a = new TranslateAnimation(0,0,-10f,0);
a.setDuration(800);
a.setFillAfter(true);
r1.startAnimation(a);
}