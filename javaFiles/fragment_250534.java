NObject refEx = Javonet.New("RefExample");  
//Wrap Java integer in AtomicReference to allow passing by reference  
AtomicReference<Integer> myInt = new AtomicReference<Integer>(10);  

refEx.invoke("Method",new NRef(myInt));  

System.out.println(myInt.get());  
//Output will display number "55" because int passed by reference has been modified within the method body.