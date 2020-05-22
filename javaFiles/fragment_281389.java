public static int calcNumberOfHippos(int[] hippos) {
int numOfHippos = 0;
for (int i = 0; i < hippos.length; i++) {
        if (hippos[i] >= 75)
        {
            numOfHippos++;
        }    
    }
    return numOfHippos;
}