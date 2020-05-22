do{ 
String line = src.nextLine();
    String []  inputs = null;
    if(!line.matches("\\s*")){
        String n ;
        String id ;
        int qty;

        inputs = line.split(" ");
        if(inputs.length ==3)
        {
           n = inputs[0];
           id = inputs[1];
           qty  = (int) Integer.parseInt(inputs[2]);
        }
        else if(inputs.length ==2) 
        {
             id = inputs[0];
             qty  = (int) Integer.parseInt(inputs[1]);
        }

       // Your Logic

}
else
break;
}while(a==0)