class MyPlugin implements Plugin{
     public void onEvent(PluginContext ctx, Event e){
         //this is only useful if we only care about a few types
         if( e instanceOf Event2){
            //we know this is Arg4
            Arg4 arg4 = (Arg4) e.getArgs()[0];
            ...
         }

     }
 }