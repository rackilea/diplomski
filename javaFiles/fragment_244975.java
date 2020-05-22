function fun(objEnumeration){
var res =" ";
while (objEnumeration.hasMoreElements()) {
  var itr = objEnumeration.nextElement();
  var v = "insert into table_Xyz (idXyz, value) values ("+ itr.idXyz.toString()+ ", " + itr.value.toString() +");\n"
  res = res + v;
}
return res;
}

fun(heap.objects("com.demo.test.Xyz"));