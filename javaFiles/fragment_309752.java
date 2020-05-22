package sampleserver;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;


public class SampleServer{

    private ObjectOutputStream output; //output stream->flows from my computer to the other computer
    private ObjectInputStream input; //input stream->receive stuff
    private ObjectInputStream name; //input stream->receive stuff
    private Socket connection; //socket variable
    private String user;
    private String ip;
    private PrintWriter p;
    private BufferedReader fromC;
    private serverTest server; //Saves the server test to append messages.

    //constructor
    public SampleServer(Socket c, String username, String userip, serverTest t){  //EDITED!!
        connection = c;
        server = t;
        ip= userip;
        user= username;             
        setupStreams(); //set up output and input stream
    }

    public void run() //This method gets called when Thread starts running
    {
        whileChatting();
        closeAll();
    }

   //get stream to send and receive data
   private void setupStreams(){
       try{
       output = new ObjectOutputStream(connection.getOutputStream()); //computer who we communicate to
       output.flush(); //bytes of information that is send to other person (leftover)
       input = new ObjectInputStream(connection.getInputStream()); //receive messages
       showMessage("\n Streams are now setup! \n");
       }catch(IOException ioException){
           ioException.printStackTrace();

       }
   }

   //actual chat conversation
   private void whileChatting(){
       String message = "You are now connected!";
       sendMessage(message); 
       do{
           try{
               message = (String) input.readObject(); //views it as an object and make sure it's a string
               showMessage("\n" + message);
           }catch(Exception e){
               //showMessage("\nError!");
           }
       }while(!message.equals("CLIENT - END"));

   }

   //close streams and sockets 
   public void closeAll(){
       showMessage("\n Closing connection... \n");
       try{
           output.close();
           input.close();
           connection.close();
       }catch(IOException ioException){
           ioException.printStackTrace();

       }
   }

   //send message to other computer
   public void sendMessage(String message){
       try{
           output.writeObject("SERVER - " +message); //sends the mesage to the output stream
           output.flush(); //push extra bytes to user
       }catch(IOException ioException){
           showMessage("\n ERROR!"); //put in the chat area

       }

   }

   //updates chatWindow
   private void showMessage(String text){
       server.showMessage(text);
   }
}