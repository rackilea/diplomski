ArrayList<TextView> spots = new ArrayList<TextView>();

for(int i = 1; i < 11; i++) {
    int id = getResources().getIdentifier("spot" + i, "id", getPackageName());
    spots.add((TextView) findViewById(id));
}