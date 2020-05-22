String tempstring;  
String readerData = "";  
while((tempstring = reader.readLine()) != null){
        readerData += tempstring;
        System.out.println("Client: " + tempstring);
}
System.out.print(readerData);