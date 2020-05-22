ArrayList<Integer> arrayOfIcons = new ArrayList<>();

Field[] drawables = R.drawable.class.getFields();
for (Field f : drawables) {
    try {
        int resID = getResources().getIdentifier(f.getName() , "drawable", getPackageName());
        arrayOfIcons.add(resID);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

ImageView imageView = findViewById(R.id.imageView);
imageView.setImageResource(arrayOfIcons.get(0));