int samples = 100; //the higher the more accurate, however slower
 float derivativeAverage = 0;
 Vector2 out = new Vector2();
 for (float i=0;i<1;i+=1f/samples) {
     catmull.derivativeAt(out, i);
     derivativeAverage += out.len();
 }
 derivativeAverage /= samples;