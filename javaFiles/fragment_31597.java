public class Frame1 extends JFrame{

    private DataObject data;

    public Frame1(DataObject data){
        this.data = data;
    }


    public void doStuff(){
        // ...do some stuff
        data.value1 = "Some new value";
    }       
}



public class Frame2 extends JFrame{

    private DataObject data;

    public Frame2(DataObject data){
        this.data = data;
    }


    public void whatever(){
        if( data.value1.equals("Some new value") )
            // ...do some stuff
    }       
}