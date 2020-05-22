public static int[] numCorrects(char[] leftarray, char[] rightarray){
    int counter[] = new int[2];
    counter[0] = 0;
    counter[1] = 0;
    boolean taken[] = new boolean[rightarray.length];
    for (int i=0;i<taken.length;i++)
        taken[i] = false;

    for (int i = 0; i < leftarray.length; i++) {
        if(leftarray[i]==rightarray[i]){ counter[0]++; taken[i] = true; }
        else {
            for (int n = 0; n < leftarray.length; n++) {
                if (leftarray[i] == rightarray[n] && leftarray[n] != rightarray[n] && !taken[n]) {
                    taken[n] = true;
                    counter[1]++;
                    break;
                }
            }
        }
    }
    return counter;
}