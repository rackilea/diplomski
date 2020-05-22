public static void main(String[] args) {
    String str = "Hello my name is John and John and I like to go...";
    String find = "John and";

    String[] sp = str.split(" +"); // "+" for multiple spaces

    String[] spMulti = find.split(" +"); // "+" for multiple spaces
    for (int i = 2; i < sp.length; i++) {
        int j = 0;
        while (j < spMulti.length && i+j < sp.length 
                                  && sp[i+j].equals(spMulti[j])) {
            j++;
        }           
        if (j == spMulti.length) { // found spMulti entirely
            StringBuilder surr = new StringBuilder();
            if (i-2 > 0){ surr.append(sp[i-2]); surr.append(" "); }
            if (i-1 > 0){ surr.append(sp[i-1]); surr.append(" "); }
            for (int k = 0; k < spMulti.length; k++) {
                if (k > 0){ surr.append(" "); }
                surr.append(sp[i+k]);
            }
            if (i+spMulti.length < sp.length) {
                surr.append(" ");
                surr.append(sp[i+spMulti.length]);
            }
            if (i+spMulti.length+1 < sp.length) {
                surr.append(" ");
                surr.append(sp[i+spMulti.length+1]);
            }
            System.out.println(surr.toString());
        }
    }
}