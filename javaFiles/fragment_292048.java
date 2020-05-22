// Create the proccess in JAVA
Process proc = Runtime.getRuntime().exec("Name of application");

// Receive outputs from another program inside Java by a stream
InputStream ips = proc.getInputStream();

// Using the stream to get the messages from another program
String output = "";
int c = 0;
while ((c = ips.read()) != -1){
    output+= (char)c;
}

//Inputs messages into another program
OutputStream ops = proc.getOutputStream();
ops.write("an byte array");