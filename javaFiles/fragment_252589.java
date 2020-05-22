for(int i=0; i<nameList.length; i++) {
    if (nameList[i] == null || nameList[i].equals("-1") || age[i] < 0) {
        // Invalid; go to the next one.
        continue;
    } else { // (not strictly necessary)
        System.out.println(nameList[i] + " " + age[i]);
    }
}