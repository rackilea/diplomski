String [] abc=new String[]{"Joe","John"};
Object ob=abc;
...
if(ob instanceof String[]){
   String[] str = (String[])ob;
}else{...}