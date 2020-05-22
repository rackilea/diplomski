public Mat overlayImage(Mat background, Mat foreground)//, Point location)
    {
          Mat mask = new Mat();
          Imgproc.resize(mCurrentMask, mask, background.size());

          Mat source = new Mat();             
          Imgproc.resize(foreground, source, background.size()); 

          source.copyTo(background,mask);
          source.release();
          mask.release();
          return background;
    }

    public void createMask (Mat sprite){
        mCurrentMask = new Mat(sprite.height(),sprite.width(),24);
        double f[] = {1,1,1,0};
        double e[] = {0,0,0,0};
        for(int y = 0; y < (int)(sprite.rows()) ; ++y)
        {
              for(int x = 0; x < (int)(sprite.cols()) ; ++x)
              {     
                  double info[] = sprite.get(y, x);                 
                  if(info[3]>0) //rude but this is what I need
                  {
                      mCurrentMask.put(y, x, f);
                  } 
                  else mCurrentMask.put(y, x, e);
              }
        } 
    }