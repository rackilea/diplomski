// code at sender side
StreamConnectionNotifier service =  (StreamConnectionNotifier) Connector.open( url );
//System.out.println("opened");
StreamConnection con = (StreamConnection) service.acceptAndOpen();
OutputStream outputStream = con.openOutputStream();


// file to send
Scanner in = new Scanner(inFile);

//just count lines
String s=null;
int countLines=0;
while(in.hasNext()) {
    s=in.nextLine();
    countLines++;
}

//send num of lines
outputStream.write(Integer.toHexString(countLines).getBytes());
try{Thread.sleep(100);} catch(InterruptedException e){}

//send lines
in = new Scanner(inFile);
for(int i=0; i<countLines; i++) {
    s=in.nextLine()+"\n";
    outputStream.write(s.getBytes());
    Thread.sleep(100);
}