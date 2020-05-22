ArrayList<Integer> a = new ArrayList<>(11);
for (int i = 0; i <= 10; i++){ //to generate from 0-10 inclusive. 
                               //For 0-9 inclusive, remove the = on the <=
    a.add(i);
}
Collections.shuffle(a);
a = a.sublist(0,4);
//turn into array