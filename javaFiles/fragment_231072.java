if (stringList.size() % 2 == 1) {
    middle = stringList.get(stringList.size()/2).length();
} else {
    middle = (stringList.get(stringList.size()/2).length()
           + stringList.get(stringList.size()/2-1).length()) / 2.0;
}