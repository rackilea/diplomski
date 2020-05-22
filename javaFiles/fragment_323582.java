Context ourContext;

public ChatCursorAdapter(Context context, Cursor c) {       
    super(context, c, 0);
    ourContext = context;
}

@Override
public void bindView(View view, Context context, Cursor cursor) {
    ...
    new AsyncImageSetter(holder.myImage, picPath, ourContext.getContentResolver()).execute();
    ...
}