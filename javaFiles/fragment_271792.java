//A request to the use a functionality of the Server come in, in the easiest way you are sending a String, and than trying to match it here
if(recievedString=="doWhatever"){
Server server.doWhatever(); //calling the according method on the Server Object you passed by creation of the ClientServerConnection Object
//now return something to the client, according to whatever the Method did 
}else if(recievedString=="doSomethingElse"){
//same again, according to whatever the now requested method does
}else{
//the client requested something you do not provide, need some sort of handling here
}