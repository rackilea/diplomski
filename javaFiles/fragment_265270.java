if (blob.getRect().intersects(screenRects.get(0)) && !region1){
     println("region1-"+millis());
       String filename = dataPath("sample.wav");
           SamplePlayer sp = new SamplePlayer(ac, SampleManager.sample(filename));
           ac.out.addInput(sp);
     region1 = true;
   } 
   else if (region1 == true){ 
     region1 = false;
   }