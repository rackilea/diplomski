String arg = args[0];
    String[] argsArray = arg.split("");
    int[] intArray = new int[argsArray.length];
    for (int i =0;i<intArray.length;i++){
        intArray[i]=Integer.parseInt(argsArray[i]);
    }