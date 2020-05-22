public CustomMarkerView markerView(Context context)
{
    CustomMarkerView mv = new CustomMarkerView(context, R.layout.custom_marker, 16, Color.WHITE);
    mv.setOffset(- mv.getWidth() / 2, -mv.getHeight()-25);
    return mv;
}