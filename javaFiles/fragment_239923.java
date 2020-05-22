L0
    LINENUMBER 23 L0
    LDC "cip"
    ASTORE 1
   L1
    LINENUMBER 24 L1
    LDC "ciop"
    ASTORE 2

   // cip + ciop

   L2
    LINENUMBER 25 L2

    NEW java/lang/StringBuilder
    DUP
    ALOAD 1
    INVOKESTATIC java/lang/String.valueOf(Ljava/lang/Object;)Ljava/lang/String;
    INVOKESPECIAL java/lang/StringBuilder.<init>(Ljava/lang/String;)V
    ALOAD 2
    INVOKEVIRTUAL java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    INVOKEVIRTUAL java/lang/StringBuilder.toString()Ljava/lang/String;

    ASTORE 3

    // new StringBuilder(cip).append(ciop).toString()

   L3
    LINENUMBER 26 L3

    NEW java/lang/StringBuilder
    DUP
    ALOAD 1
    INVOKESPECIAL java/lang/StringBuilder.<init>(Ljava/lang/String;)V
    ALOAD 2
    INVOKEVIRTUAL java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    INVOKEVIRTUAL java/lang/StringBuilder.toString()Ljava/lang/String;

    ASTORE 4
   L4
    LINENUMBER 27 L4
    RETURN