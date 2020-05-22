// you can use this for convenience
public ShipFactory(Context context){
    this(new BitmapProvider(context), new Accelerometer(context));
}

// use this for testing because you can provide mock versions
public ShipFactory(BitmapProvider provider, Accelerometer accel){
    this.provider = provider;
    this.accel = accel;
}

// wrapping BitmapFactory because it is a buncha static methods... aka a pain to mock
class BitmapProvider {
    Context context;
    public BitmapProvider(Context context){
        this.context = context;
    }

    public Bitmap getBitmap(int resId){
        return BitmapFactory.decodeResource(context.getResources(), resId);
    }
}