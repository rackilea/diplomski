char[] letterarray;
letterarray=new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
int[] letterTimes;
letterTimes=new int[26];
int numMostLetter=0;
for(int i=0; i<sentencel.length(); i++){
    for(int j=0; j<letterarray.length; j++){
        if(sentencel.charAt(i)==letterarray[j]){
            letterTimes[j]++;
            break;
        }
    }
}
Arrays.sort(letterTimes);
numMostLetter=letterTimes[letterTimes.length-1];