boolean didIt = false;
ArrayList<JTextField[]> listOfStuff = new ArrayList<JTextField[]>();
listOfStuff.add({ text1, text2, text3 });
listOfStuff.add({ text3, text4, text7 });
....
listOfStuff.add({ text13, text44, text14 });

for (JTextField[] fields : listOfStuff) {
    didIt = didIt || setToThree(fields[2], fields[0], fields[1]);
}

if (!didIt) {
    Statement here
}