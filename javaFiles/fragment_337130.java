@Test
public void subequences() {

    String input = "aabbccaacccccbbd";
    String query = "a+b+";

    // here to store tokens of a query: e.g. {a, +}, {b, +}
    char[][] q = new char[query.length() / 2][];

    // here to store counts of subsequences ending by j-th token found so far
    int[] c =  new int[query.length() / 2];   // main
    int[] cc = new int[query.length() / 2];   // aux        

    // tokenize
    for (int i = 0; i < query.length(); i += 2)
        q[i / 2] = new char[] {query.charAt(i), query.charAt(i + 1)};

    // init
    char[] sub2 = {0, 0};        // accumulator capturing last 2 chars
    char[] sub4 = {0, 0, 0, 0};  // accumulator capturing last 4 chars

    // main loop
    for (int i = 0; i < input.length(); i++) {

        shift(sub2, input.charAt(i));
        shift(sub4, input.charAt(i));

        boolean all2 = sub2[1] != 0 && sub2[0] == sub2[1];  // true if all sub2 chars are same
        boolean all4 = sub4[3] != 0 && sub4[0] == sub4[1]   // true if all sub4 chars are same
              && sub4[0] == sub4[2] && sub4[0] == sub4[3];

        // iterate tokens
        for (int j = 0; j < c.length; j++) {

            if (all2 && q[j][1] == '+' && q[j][0] == sub2[0]) // found match for "+" token
                cc[j] = j == 0             // filling up aux array
                      ? c[j] + 1           // first token, increment counter by 1
                      : c[j] + c[j - 1];   // add value of preceding token counter

            if (all4 && q[j][1] == '-' && q[j][0] == sub4[0]) // found match for "-" token
                cc[j] = j == 0 
                      ? c[j] + 1 
                      : c[j] + c[j - 1];
        }
        if (all2) sub2[1] = 0;  // clear, to make "aa" occur in "aaaa" 2, not 3 times
        if (all4) sub4[3] = 0;
        copy(cc, c);            // copy aux array to main 
        }
    }
    System.out.println(c[c.length - 1]);
}


// shifts array 1 char left and puts c at the end
void shift(char[] cc, char c) {
    for (int i = 1; i < cc.length; i++)
        cc[i - 1] = cc[i];
    cc[cc.length - 1] = c;
}

// copies array contents 
void copy(int[] from, int[] to) {
    for (int i = 0; i < from.length; i++)
        to[i] = from[i];
}