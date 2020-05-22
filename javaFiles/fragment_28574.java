if (temparray.get(i).contains("_")) {
    System.out.println("True" + temparray.get(i).length() + " " + temparray.get(i));
    String[] temp = temparray.get(i).split("_");
    System.out.println(temp[0]);
    System.out.println(temp[1]);
    friendsOld.add(new Friend(temp[0],temp[1]));
}