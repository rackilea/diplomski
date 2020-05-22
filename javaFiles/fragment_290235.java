try {
    List<Future<String>> resultList=executor.invokeAll(list);
    for(Future<String> f:resultList){
    //  if(f.isDone()){

                System.out.println(f.get());

        //}
    }
} catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}catch (ExecutionException e) {
    // TODO Auto-generated catch block
    System.out.println("HELLO SOME ERROR");
//  e.printStackTrace();
}