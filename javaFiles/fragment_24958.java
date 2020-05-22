L0
 LINENUMBER 13 L0
 LDC "First"
 ASTORE 1
L1
 LINENUMBER 14 L1
 LDC "Second"
 ASTORE 2
L2
 LINENUMBER 15 L2
 LDC "Third"
 ASTORE 3
L3
 LINENUMBER 16 L3
 NEW java/lang/StringBuilder
 DUP
 INVOKESPECIAL java/lang/StringBuilder.<init> ()V
 ALOAD 1
 INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 ALOAD 2
 INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 ALOAD 3
 INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
 ASTORE 4