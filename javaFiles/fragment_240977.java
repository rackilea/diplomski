method1(){
  method2();
}

@Transactional
method2(){
  // some update in DB -> fails because there is no transaction
}