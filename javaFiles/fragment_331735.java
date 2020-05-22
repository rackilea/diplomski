for( int i=0; i < 360; i++ ){   
         float x = 1 + i;
         float y = (float)(Math.sin( Math.toRadians(i+currentOffset)));
         bridge.particles.get(j).setTransform(x, y, 0);
 }
currentOffset+=1;