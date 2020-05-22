...
@Command
public void open(@BindingParam("id") Integer id, 
                 @BindingParam("applet") Applet applet){
    applet.invoke("open", new String[]{id.toString(),"user jakiś tam"} );   
}