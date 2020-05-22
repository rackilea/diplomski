float allWidth = 0.0;
for (int i = 0; i < listAnswers2.size(); i++) {
    Log.e("allWidth", String.valueOf(allWidth));
    View view = listAnswers2.get(i).getView();
    allWidth += (float) view.getWidth() + 20F;
}