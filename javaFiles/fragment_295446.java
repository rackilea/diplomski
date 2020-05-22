Bridge.init();
Bridge.LoadAndRegisterAssemblyFrom(new File("clAESEncripcion.j4n.dll"));
aesencryption.AESObjectEnc aesObjectEnc = new aesencryption.AESObjectEnc();

public void javaMethod(){
    String val = "To encrypt";
    String receive_val = "";
    receive_val = aesObjectEnc.CallEncrypt(val);
    System.out.println(receive_val);
}