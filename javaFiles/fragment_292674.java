AnimationDrawable createFrom(Context context, int id1, int id2) {
    AnimationDrawable ad = new AnimationDrawable();
    ad.addFrame(context.getResources().getDrawable(id1), 1000);
    ad.addFrame(context.getResources().getDrawable(id2), 1000);
    return ad;
}