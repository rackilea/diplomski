private void initializeData() {
    classmates = new ArrayList<>();
    for (int i = 1; i <= 38; i++) {
        //Exclude number 32
        if (!(i == 32)) {
            Context ctx = getContext();
            int resId = ctx.getResources().getIdentifier(String.format("num%d", i), "drawable", ctx.getPackageName());
            classmates.add(new Classmates(classmateName[i], resId);
        }
    }
}