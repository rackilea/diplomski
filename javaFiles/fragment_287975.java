public class DisplayMeasurement {

    public int widthScreen = 0;
    public int heightScreen = 0;

    public void DisplayMeasurement(Context context){
          Point size = new Point();
          WindowManager w = (WindowManager) mContext.getSystemService(mContext.WINDOW_SERVICE);

          if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.HONEYCOMB_MR2){
               w.getDefaultDisplay().getSize(size);  
               widthScreen = size.x;
               heightScreen = size.y; 
          } else {
               Display d = w.getDefaultDisplay(); 
               widthScreen = d.getWidth(); 
               heightScreen = d.getHeight(); 
          }
    }

    public int getWidthScreen(){
        return widthScreen;
    }

    public int getHeightScreen(){
        return heightScreen;
    }   
}