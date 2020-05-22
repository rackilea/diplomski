public class MyApp(){
    ArrayList contacts;
    ...

    public void run(){                  //this happens when we start our app
        this.contacts = new ArrayList();
        FileReader fr = new FileReader ("C:\WhereverYourFileIs\Contacts.file");
        BufferedReader br = new BufferedReader(fr);
        //here you use a loop to read the contacts via "br" from the file and fill them into your array...I can't provide you more code, since the exact data structure is up to you.
    }

    //now we want to send our contacts array to the already connected server:
    public sendArrayToServer() {
        BufferedOutputStream bos = new BufferedOutputStream (this.connection.openOutputStream());
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this.contacts);
         //If you use readUTF() in the server, you need to call here something like oos.writeUTF(this.contacts.toString()); or even need to use another parser method which exactly creates the string you want.
        this.connection.close();    //closing the connection...don't forget exception handling!
        //oos.close();      //do this instead of "this.connection.close()" if you want the connection to stay open...
    }
}