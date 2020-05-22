imageView.setImageResource(getDrawableFromName(context,"image1.png""));

public static int getDrawableFromName(Context context, String drawableName) {
    return context.getResources().getIdentifier(drawableName, "drawable",
            context.getPackageName());
}