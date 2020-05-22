//declare an instance variable
ButtonClickNotify buttonNotify;
//Initiate the iterface in the constructor
public MyListAdapter(Context context /*and other parameters*/){
   //after other constructor methods including calling super
   try{
        buttonNotify=(MainActivity)context;
   }catch(Throwable e){
       //interface is not implemented
   }
}

//at the button onclick
holder.iButton.setOnClickListener(new View.OnClickListener{
     @Overrride 
     public void onClick(View v){
         try{
            buttonNotify.onButtonClick(position);
         }catch (Throwable e){
            //interface can be null
         }
     }
});