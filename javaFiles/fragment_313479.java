Field[] fontFields = R.font.class.getFields();
ArrayList<Integer> fonts = new ArrayList<>();

for (Field field : fontFields) {
    try {
        Log.i("TAG", field.getName());
        fonts.add(field.getInt(null));
    } catch (Exception e) {
        e.printStackTrace();
    }
}

for (int font : fonts){
    Typeface typeFace = appContext.getResources().getFont(font);
    Log.i("TAG", String.valueOf(typeFace.isBold()));
}