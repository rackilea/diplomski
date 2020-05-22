boolean isIsogram = true; 
Scanner scanner = new Scanner(System.in);
String string = scanner.next();
long start = System.currentTimeMillis();
char words[] = string.toCharArray();

for (int i = 0 ; i <= words.length - 1; i++){
    for(int j = 0; j <= words.length - 1; j++){
         if(words[i] == words[j]){
             isIsogram = false;
             break; //I agree with the first answer
         }
    }
    if (!isIsogram)
        break; 
}  

long finish = System.currentTimeMillis();
System.out.println(isIsogram + " time:" + (finish-start) );