InterpreterSingleton {  
    public static final void Console console = new Interpreter();
}
....

class ClientList {
 Integer clients = 0;
 public void addClient(Client c) {
    ....
    InterpreterSingleton.console.print("Client added, clients now are " + clients);
 }