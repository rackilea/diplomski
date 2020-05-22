Hashtable textViews = new Hashtable<String, TextView>();
List<String> arStan = new ArrayList<String>();
arStan.add("wyniszczenie");
arStan.add("wychudzenie");
arStan.add("niedowaga");

for(String s : arStan) {
    int myId = getResources().getIdentifier(s + "_zakres.bmi", "id", getPackageName());
    TextView myTextView = (TextView)t.findViewById(myId);
    textViews.put(s + "_zakres.bmi", myTextView);
}

// When you need to get one of the TextViews:
TextView tv = textViews.get("niedowaga_zakres.bmi");
// Do something with tv.