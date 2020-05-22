} catch (ConnectException e) { //When the connection is refused upon connecting to the server
      //promt the user here
      System.out.println("Connection refused");
      break; //to quit the infinite loop
} catch (IOException e) { //when connection drops, server closed, loses connection
     //promt the user here
     System.out.println("Disconnected from server");
     break; //to quit the infinite loop
}