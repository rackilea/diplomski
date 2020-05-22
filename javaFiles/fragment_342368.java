PrintStream originalSysOut=System.out;

    SplitOutputStream split=new SplitOutputStream(
        new FileOutputStream("c:\\work\\text.txt"),
        originalSysOut
    );
    PrintStream splitPs=new PrintStream(split,true);

    System.setOut(splitPs);

    System.out.println("some text");