//initialization
int[] left = {};//setup left
int[] right = {};//setup right
//keys
int[] keys = {};//setup keys

for(int r = 0; r < 10; r++) {//the number of rounds
    for(int i = 0; i < right.length; i++){
        right[i] = left[i] ^ (right[i] ^ keys[r]);
    }

    //swap lists to do the next round
    int[] temp = left;
    left = right;
    right = temp;
}
//remark: the result (right) will be stored in left
//use left as resulting right