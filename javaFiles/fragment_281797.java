PriorityQueue<T> queue= new PriorityQueue<T> () ; 
List<T> list = new ArrayList<T>();

while(!queue.isEmpty()){
       list.add(0, queue.poll());
    }