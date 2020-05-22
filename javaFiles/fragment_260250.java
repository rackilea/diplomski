final boolean[] buttonflag=new boolean[]{false};
Editbutton.setOnClickListener( new OnClickListener(){ 
   @Override
   public void onClick( View v ){
     buttonflag[0]=true;
   }
}