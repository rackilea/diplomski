public class TestArray  {

public static void main(String[] args)  {
int[] anArray={ 1,2,3,4,5,6,7,8,9};

System.out.println(anArray.length);
int min=0;
int max=0;

for(int i=0; i<anArray.length; i++){
    if(anArray[i] <(anArray[min]) )
        min=i;

    if(anArray[i]>(anArray[max]) )
        max=i;
}

System.out.println(max);
System.out.println(min);
}
}