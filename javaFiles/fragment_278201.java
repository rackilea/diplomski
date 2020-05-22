try{
    if(root.isChecked()==true){
       Runtime.getRuntime().exec("su");
    }
} catch (Exception e){
     e.printStackTrace();
}