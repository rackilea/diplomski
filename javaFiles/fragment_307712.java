String numbers = "01010101"
char[] charNumbers = numbers.toCharArray();
char[] resultNumbers = new char[numbers.lenght];

char min = charNumbers[0];
int index = 0;
for(int j = 0 ;j=charNumbers.length;j++){
   for(int i = 0 ;i=charNumbers.length;i++){
      if(min<charNumbers[i]){
         index = i;
         min = charNumbers[i];
         }
      }
   resultNumbers[j]=min;
   charNumbers[index] = (char)255;
}