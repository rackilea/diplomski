int[] lettercount = new int[26];
for(int i = 0; i < 26; i++){
    //Set every single number in the array to 0.
    lettercount[i] = 0;
}

for(char s : paragraph.toCharArray()){
    int converted = (int) s;
    converted -= 97;
    if(converted >=0 && converted <=25){
        lettercount[converted] += 1;
    }
}

//Print out the letter with the frequencies.
for(int i = 0; i < 26; i++){
    char convertback = (char) (i+97);
    String stars = "";
    for(int j = 0; j < lettercount[i]; j++){
        stars += "*";
    }
    System.out.println(convertback + " " + stars + " - " + lettercount[i]);
}