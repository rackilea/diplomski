Date d;
SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
try{
    d=sdf.parse("20-12-2016",0);
}
   catch(Exception ex){
   ex.printStackTrace();
}
    System.out.println(d);
}