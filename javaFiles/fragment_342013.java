String[] kata = new String[10];
for (int i = 0; i < hasil.size(); i++) {
    for (int k = 0; k < find.size(); k++) {

        kata = hasil.get(i).split(" ");
        for (int j = 0; j < kata.length; j++) {
            if (kata[j].equals(find.get(k))) {
                c++;
            }
        }
        System.out.println(find.get(k) + " = " + c);
        c = 0;
    }
}