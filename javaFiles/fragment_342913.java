boolean isCorrect = false;
System.out.print("Enter your password: "); 
while(!isCorrect){
    myPass = fromUser.readLine();

    toServer.writeBytes(myPass + "\n");

    if(myPass == fromServer.readLine()){
        isCorrect = true;
    }
    myPass = fromServer.readLine();

    System.out.println(myPass);
}