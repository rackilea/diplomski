Application 1 :

 If(operationSet){
SendRequestToREST(operation)
notifyApp2()// if your app 2 has rest endpoint you can use RestTemplate
}

Application 2 :

 ListenToRest();
if(operationIsSet){
doSomething()
}