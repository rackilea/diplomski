public class Client {
  public static void main(String[] args) throws Exception{
    MyClassLoader myClassLoader = new MyClassLoader(clientSocket);
    Class clazz = myClassLoader.findClass(null);
    ProcessAlgorithm iAction = (ProcessAlgorithm) clazz.newInstance();
   }
}