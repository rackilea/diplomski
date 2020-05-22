class Lift {
 int capacity;
 boolean emptying;
 Stack<String> stack = new Stack<>();

 public Lift(int maxCapacity) {
  this.capacity = maxCapacity;
  this.emptying = false;
 }


 public boolean push(String item) {
  if (!emptying && stack.size() < capacity) {
    stack.push(item);
    return true;
  } else {
     //state is emptying
     emptying = true;
     return false
  }
 }

 public void pushtoQueue(Queue queue) {
   while(!stack.isEmpty()) {
     queue.add(stack.pop();
   }
   emptying = false;
 }

}