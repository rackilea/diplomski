public static void code1()   throws javax.jms.JMSException;
  Code:
   0:   getstatic   #2; //Field consumer:Ljavax/jms/MessageConsumer;
   3:   invokeinterface #3,  1; //InterfaceMethod javax/jms/MessageConsumer.receiveNoWait:()Ljavax/jms/Message;
   8:   dup
   9:   astore_0
   10:  ifnull  23
   13:  getstatic   #4; //Field java/lang/System.out:Ljava/io/PrintStream;
   16:  aload_0
   17:  invokevirtual   #5; //Method java/io/PrintStream.println:(Ljava/lang/Object;)V
   20:  goto    0
   23:  return

public static void code2()   throws javax.jms.JMSException;
  Code:
   0:   aconst_null
   1:   astore_0
   2:   getstatic   #2; //Field consumer:Ljavax/jms/MessageConsumer;
   5:   invokeinterface #3,  1; //InterfaceMethod javax/jms/MessageConsumer.receiveNoWait:()Ljavax/jms/Message;
   10:  dup
   11:  astore_0
   12:  ifnull  25
   15:  getstatic   #4; //Field java/lang/System.out:Ljava/io/PrintStream;
   18:  aload_0
   19:  invokevirtual   #5; //Method java/io/PrintStream.println:(Ljava/lang/Object;)V
   22:  goto    2
   25:  return

}