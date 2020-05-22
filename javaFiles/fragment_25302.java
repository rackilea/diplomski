String[] myArray = new String[30000];

public void read()
{

    try {
        Scanner myLocal = new Scanner( new File("dictionary.txt"));  
        while (myLocal.hasNextLine()){

                for (int i=0; i<myArray.length; i++){
                String a = myLocal.nextLine();
                myArray[i] = a;

            }
        }

    }
    catch(IOException e){
        System.out.println(e);
    }
}

public void sort()
{   
    int n = myArray.length;

    for (int i=0; i<n; i++){
        for(int j=1; j<n-i; j++){ 
        if (myArray[j-1].compareTo(myArray[j])>0){



                swap(j, myArray);



            }

        }


    } 



}
public void swap(int j, String[] myArray)
{
    String temp = myArray[j-1];
    myArray[j-1]=myArray[j];
    myArray[j]=temp;


}

public void write()
{
    try{
        PrintStream writer = new PrintStream(new File("myIgnoreNew.txt"));
        for (int i=0; i<myArray.length; i++){
            writer.println(myArray[i] + "\n");
            }
            writer.close();
    }
    catch(IOException e){
        System.out.println(e);
    }


}