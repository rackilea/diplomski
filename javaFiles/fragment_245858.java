public static Point getDisplaySize(@NonNull Context context) {
    Point point = new Point();
    WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    manager.getDefaultDisplay().getSize(point);
    return point;
}