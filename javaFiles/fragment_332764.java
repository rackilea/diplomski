String str;      // it is dynamic let there are two values in this 'S' and 8
if (str instancof String){
   order.setProduct_Size(str);
}else{
  order.setProduct_Size(Integer.toString(str));
}