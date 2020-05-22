Field[] drawablesFields = com.your.project.R.drawable.class.getFields();
ArrayList<Drawable> drawables = new ArrayList<>();

for (Field field : drawablesFields) {
    try {
        Log.i("LOG_TAG", "com.your.project.R.drawable." + field.getName());
        drawables.add(getResources().getDrawable(field.getInt(null)));
    } catch (Exception e) {
        e.printStackTrace();
    }
}