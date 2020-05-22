public class cBalloon {

    public cBalloon(Context inContext, int w, int h) {
        this( inContext,  new Random(), w, h);
    }

    public cBalloon(Context inContext, Random randomGenerator, int w, int h) {
        super(inContext,  
              randomGenerator.nextInt(w),  
              randomGenerator.nextInt(h),  
              0,0,  50,50,  "balloon", 50,50,0);
    }
}