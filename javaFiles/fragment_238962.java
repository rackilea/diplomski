Deque<String> queue=new ArrayDeque<String>();
String line;
while ((aux = reader.readLine()) != null){
  if(queue.size()>=8){
    queue.remove();
  }
  queue.add(aux);
}
System.out.println(queue.size());//should print 8