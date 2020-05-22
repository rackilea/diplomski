private static char[] advanceArray(char[] array, int n) {
int length = array.length;
for (int i=0; i<length; i++){
    if(array[i]!=' '){
    int ch = (int)array[i];

    if(ch>96 && ch<123)
    {
        ch = ch-97;
        ch = ((ch+n)%26)+97;
    }
    else if(ch>64 && ch<91)
    {
        ch = ch-65;
        ch = ((ch+n)%26)+65;
    }

    array[i]=(char)ch;
    }
}
return array;
}