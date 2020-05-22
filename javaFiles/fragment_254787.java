List<String> labels = new ArrayList<String>();

labels.add(c.getString(2));
labels.add(c.getString(3));
labels.add(c.getString(4));
labels.add(c.getString(5));

Collections.shuffle(labels);

bOdgovor1.setText(labels.get(0));
bOdgovor2.setText(labels.get(1));
bOdgovor3.setText(labels.get(2));
bOdgovor4.setText(labels.get(3));