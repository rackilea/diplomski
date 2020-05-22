Scanner console=new Scanner(System.in);
char[] array=console.next().toCharArray();
char[] array2=array;
int count=0;
char m;
String memoryString = "";
for (int i=0; i<array.length; i++) {
    for (int j=0; j<array2.length; j++) {
        if (memoryString.contains(String.valueOf(array[i])) break;
        if (array[i]==array2[j]){
            count=count+1;  
        }
    } //end loop inner
    memoryString+=array[i]
    if (count>=2) {
          System.out.println(array[i]+" is duplicated "+count+" times!");
    }
    count=0;
} //end outer loop