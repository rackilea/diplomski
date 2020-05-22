List<String> arStan = new ArrayList<String>();
arStan.add("wyniszczenie");
arStan.add("wychudzenie");
arStan.add("niedowaga");

for(String s : arStan) {
    int myId = getResources().getIdentifier(s + "_zakres.bmi", "id", getPackageName());
    TextView myTextView = (TextView)t.findViewById(myId);
    // Do something with myTextView
}