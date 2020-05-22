MyCounter myCounter=new MyCounter();

myCounter.setMyListener(new MyListener()
{
//then override methods here
  @override
  void actionOneHappens(Object o){
  }
  @override
  void actionTwo()
  {}

  @override
  void actionThree()
  {
   //Add you code here
   Toast.makeText(getApplicationContext(),"I'm at 3",Toast.LENGTH_LONG).show()
   }



});

//start your counter
myCounter.startCounting();