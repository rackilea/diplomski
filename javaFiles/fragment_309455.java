if (array[0] == 'a'){
        this.abortBroadcast();
        Toast.makeText(context, "a", Toast.LENGTH_LONG).show();
        context.sendBroadcast(in);
    }
    else if (array[0] == 'A'){
        //this.abortBroadcast();
        //Toast.makeText(context, "A", Toast.LENGTH_LONG).show();
        //context.sendBroadcast(in);
 //insert semi colon after } below:   
 };