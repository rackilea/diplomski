String[] orgCards = {
        "ca", "ck", "cq", "cj", "c10", "c9", "c8", "c7", "c6", "c5", "c4", "c3", "c2",
        "sa", "sk", "sq", "sj", "s10", "s9", "s8", "s7", "s6", "s5", "s4", "s3", "s2",
        "da", "dk", "dq", "dj", "d10", "d9", "d8", "d7", "d6", "d5", "d4", "d3", "d2",
        "ha", "hk", "hq", "hj", "h10", "h9", "h8", "h7", "h6", "h5", "h4", "h3", "h2"
};

List<String> list = new ArrayList<String>(orgCards.length);
for (String i : orgCards) {
    list.add(i);
}
Collections.shuffle(list);
String listString = "";
for (int i=0; i<13; i++) {
    listString += " " + list.get(i);
}

TextView text = (TextView) findViewById(R.id.textField);
text.setText("my string:" + listString);