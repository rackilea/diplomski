for(int j = 0; j < i; j++) {
    String s = scr.nextLine();
    if (s.equals(">")) {
        break;
    } else {
        hs.add(s);
    }
}

for (String str : hs) {// print loop
    System.out.println("The Entries are " + str);
}