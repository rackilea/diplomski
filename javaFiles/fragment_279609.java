char inp = input.charAt(0);
//find position of user input and replace
char[] answer = tW.toCharArray();
for(int i = 0; i < answer.length; i++){
    if(s.charAt(i) == inp)
        answer[i] = inp;
}