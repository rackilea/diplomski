private static String[] tip_types;

private static String[] getTipTypes(Context context) {
    if(tip_types == null) {
        tip_types = context.getResources().getStringArray(R.array.tip_types_array);
    }
    return tip_types;
}