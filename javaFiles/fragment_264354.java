if (lives < 1) {
  // for(int df = 0; df < 1000; df++) {
  background(0);
  textSize(100);
  text("You Lost",100,100);
  dflag = true;
  //redraw();
  lives = 10;
  x = (int)random(width);
  y = (int)random(height / 2);
  velocity = new PVector(1,random(-1.4,-0.6));
  score = 0;
} else {
  textSize(13);
  background(0);
  stroke(255);
  text(score,10,10);
  String l = "";
  for (int q = 0; q < lives; q++) { l += "%"; }
  text(l,50,10);
  strokeWeight(balld);
  point(x,y);
  strokeWeight(8);
  line(paddlex,height - 30,paddlex + paddlew,height-30);
}