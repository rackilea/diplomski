Scanner in=new Scanner(System.in);

    if(in.hasNextInt()){
        System.out.println("This input is of type integer");
    }else if(in.hasNextFloat()){
        System.out.println("This input is of type float");
    }else if(in.hasNextLine()){
        System.out.println("This input is of type String");
    }else{
        System.out.println("This input is something else");
    }