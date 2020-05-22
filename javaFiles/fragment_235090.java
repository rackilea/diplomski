private convertTo4Digits(Ljava/lang/Integer;)Ljava/lang/Integer;
 L0
  LINENUMBER 46 L0
  ALOAD 1
  IFNULL L1
  ALOAD 1
  INVOKEVIRTUAL java/lang/Integer.intValue()I
  BIPUSH 100
  IF_ICMPGE L1
  SIPUSH 2000
  ALOAD 1
  INVOKEVIRTUAL java/lang/Integer.intValue()I
  IADD
  GOTO L2
 L1
  LINENUMBER 47 L1
  ALOAD 1
  INVOKEVIRTUAL java/lang/Integer.intValue()I
 L2
  LINENUMBER 46 L2
  INVOKESTATIC java/lang/Integer.valueOf(I)Ljava/lang/Integer;
  ARETURN