public interface Iscan {
void scan();
}

public EyeScannerClass implements Iscan{
 void scan(){
System.out.println("Some Person's eye scanned...")
}

public BarcodeScannerClass implements Iscan{
System.out.println("A produc's barcode from supermarket scanned...")
}

public ScannerFactory{

public static Iscan createScanner(){
//here you can choose which scanner to create by the help of polymorphism because different scanner classes implementing same scanner interface
}

}

public SomeBusinessLogicClass {

public void someMethod(){
//if the scanner impl changes you do not need to change your business logic. all change must be done in factory and the other users of that factory is not affected.
Iscan scanner=ScannerFactory.createScanner();

}

}