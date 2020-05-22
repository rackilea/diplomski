public void somethingElse(){
    try {
           String line;//Added a variable to store the current line to; readLine is 
           //dynamic, it returns the next line each call, so if we store to a variable,
           //we only call it once, and hold that value
           if((line = in.readLine()) != null){// (line = in.readLine()) != null is shorthand to store readLine to line, and then check if that returned value is null or not
               System.out.println(line);//Print out the line
               chat.append(recipient + ": " + line + "\n");//Append it
           }
     } catch (IOException e) {
        e.printStackTrace();
     }     
}