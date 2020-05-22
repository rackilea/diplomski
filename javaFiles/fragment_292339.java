String[] values = {"A", "B", "C", "D", "E"};
    final String ONE = "1";
    final String X = "X";
    int control=0;
    StringBuilder sb = new StringBuilder(values.length);
    String copy[];
    int count = Integer.parseInt(new String(new char[values.length]).replace("\0", ONE), 2) ;
    while (control <= count) {
        sb.delete(0, sb.length());
        sb.append(String.format("%" + values.length  + "s", Integer.toBinaryString(control++)).replace(' ', '0'));
        copy = values.clone();
        for (int x = 0; x < sb.length(); x ++) {
            if (sb.substring(x, x+1).equals(ONE)) {
                copy[x] = X;
            }
        }
       System.out.println(control + " " + Arrays.toString(copy));
       map.put(generateHashCode(copy),copy.clone());
    }


    System.out.println(map.values().size());