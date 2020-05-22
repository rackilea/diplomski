class Test {
 int a;
 string b;
 ArrayList<String> c;
 Test(Test t){
  this.a=t.a;
  this.b=t.b;
  this.c=new ArrayList<String>(t.c);
 }
}
FileOutputStream fos = new FileOutputStream(file);
//write a copy of original object
      fos.write(new Test(t));

}