public SnapshotDraw(Context context) {
    super(context);
    setFocusable(true);

    mBitmap = Bitmap.createBitmap(475, 720, Bitmap.Config.ALPHA_8);
}

@Override 
protected void onDraw(Canvas canvas) {
    canvas.drawColor(Color.BLACK);

    Paint p = new Paint();
    float y = 10;

    try {
        fileName = PREFIX + "2" + EXTENSION;
        bf = new BufferedReader(new FileReader(fileName));

        for(int a = 0; a < 63; a++){
            tokens = bf.readLine().split(" \n");
            for(int b = 0; b < 63; b++){

                weight = Byte.parseByte(tokens[b]);

                x_scalar = b*MAG;
                y_scalar = a*MAG;   

                p.setColor(new Colour().getColour(weight));
                canvas.drawRect((X_OFFSET + x_scalar), (Y_OFFSET + y_scalar), ((MAG + X_OFFSET) + x_scalar), ((MAG + Y_OFFSET) + y_scalar), p);
            }
        } 
    } catch (FileNotFoundException ex) {
        Logger.getLogger(NetworkUtilities.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(NetworkUtilities.class.getName()).log(Level.SEVERE, null, ex);
    }

    canvas.drawBitmap(mBitmap, 10, y, p);
}