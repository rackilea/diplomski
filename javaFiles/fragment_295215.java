File file = new File(name);
    Scanner inputFile = new Scanner(file);

    int count =0;   //To count the amount of numbers 
                   //in the file.

    int index = 0;  //Index for an array.

    int number;

    //Determine the amount of numbers in a file.
    while(inputFile.hasNext()){
        inputFile.nextInt();
        count++;
    }

    //Create an array as big as the amount of numbers 
    //in the file.
    array = new int[count];
    inputFile.close();
    inputFile = new Scanner(file);
    //Store the content of the file into the array.
    while(inputFile.hasNext() && index<array.length){
        number = inputFile.nextInt();
        array[index] = number;
        index++;
    }
    inputFile.close();  //Close the file.