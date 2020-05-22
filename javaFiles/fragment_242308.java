List<TextView> textviews = new ArrayList<>();
Resources res = getResources();

for (int i = 1; i <=272; i++) {

    int id = res.getIdentifier("resul" + i, "id", getContext().getPackageName());
    TextView tv = (TextView) findViewById(id);
    textviews.add(tv);
}