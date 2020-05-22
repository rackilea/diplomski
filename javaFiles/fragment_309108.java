ArrayList<String> listL = new ArrayList<String>();
ArrayList<String> listR = new ArrayList<String>();
while (x.hasNextLine()){
    x.nextLine();
    if (x.hasNext()){
        listL.add(x.next());
    } else {
        listL.add("");
    }

    if (x.hasNext()){
        listR.add(x.next());
    } else {
        listR.add("");
    }
}
System.out.println(listL);
System.out.println(listR);