PrintWriter printWriter[];
    int numberOfPrintWriters = 10;

    StringWriter stringWriter = new StringWriter();
    printWriter = new PrintWriter[numberOfPrintWriters];

    //using first printWriter
    PrintWriter printWriter[0] = new PrintWriter(stringWriter);
     try {
        printWriter[0].write(str, 0, 26);
        //or
        printWriter[0].print("ZZZ");
    }catch(Exception e){
      e.printStackTrace();
    }finally {
        printWriter[0].close();
    }

    //Similarly you can use other printWriters in array using their index like printWriter[i]