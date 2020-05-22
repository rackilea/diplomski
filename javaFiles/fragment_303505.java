ArrayList<String[]> udvPairs = new ArrayList<>();
String[] temp = new String[2];
String notOne = "1";
for (int i = 0; i < funcObjects.size(); i++) {
    notOne = notOne += funcObjects.get(i);
}
temp[0] = "1";
temp[1] = notOne;
udvPairs.add(temp);
temp = new String[2];
temp[1] = "1";
temp[0] = notOne;
udvPairs.add(temp);
for (int i = 0; i < funcObjects.size() - 1; i++) {
    //System.out.println("i=" + i);
    //System.out.println(function.size());
    for (int j = 0; j < funcObjects.size() - i; j++) {
        //System.out.println("j=" + j);
        for (int skip = 0; skip < funcObjects.size() - i - j; skip++) {
            //System.out.println("skip=" + skip);
            String u = "1";
            String dv = "1";
            u += funcObjects.get(j);
            for (int start = j + skip + 1; start <= j + i + skip; start++) {
                u += ufuncObjects.get(start);
            }
            for (int end = 0; end < j; end++) {
                dv += funcObjects.get(end);
            }
            for (int end = j + 1; end < j + skip + 1; end++) {
                dv += funcObjects.get(end);
            }
            for (int end = j + i + 1 + skip; end < funcObjects.size(); end++) {
                dv += funcObjects.get(end);
            }
            //}
            //System.out.println("Pair " + pairCounter + "; u: " + u.toString() + " dv: " + dv.toString());
            temp = new String[2];
            temp[0] = u;
            temp[1] = dv;
            boolean addIt = true;
            for (int x = 0; x < udvPairs.size(); x++) {
                if (udvPairs.get(x)[0].equals(u) && udvPairs.get(x)[1].equals(dv)) {
                    addIt = false;
                    x = udvPairs.size();
                }
            }
            if (addIt) {
                udvPairs.add(temp);
            }
            //pairCounter++;
        }
    }
}