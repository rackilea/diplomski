float fractal(int x,int y,float gridSubs,float gain,int octaves){
  float total = 0;
  float freq = 1.0/gridSubs;
  float amp = gain;

  for(int f=0;f<octaves;f++){
    total += noise(x*freq,y*freq)*amp;
    freq *= 2.0;
    amp *= gain;
  }
  return total;
}