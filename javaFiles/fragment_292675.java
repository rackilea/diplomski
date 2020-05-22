AnimationDrawable createFromArray(Context context, int arrayId) {
    TypedArray array = context.getResources().obtainTypedArray(arrayId);
    AnimationDrawable ad = new AnimationDrawable();
    for (int i = 0; i < array.length(); i++) {
        ad.addFrame(array.getDrawable(i), 1000);
    }
    array.recycle();
    return ad;
}