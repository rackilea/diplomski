public static void main(String[] args) {
    ArrayQmerge q1 = new ArrayQmerge();
    q1.enqueue(1);
    q1.enqueue(2);
    q1.enqueue(3);
    q1.enqueue(4);
    q1.enqueue(11);
    ArrayQmerge q2 = new ArrayQmerge();
    q2.enqueue(5);
    q2.enqueue(6);
    q2.enqueue(7);
    q2.enqueue(8);
    q2.enqueue(9);
    q2.enqueue(10);
    q2.enqueue(12);
    System.out.println(q1);
    System.out.println(q2);
    q1.mergeQs(q2);
    System.out.println(q1);
    System.out.println(q2);
}

static class ArrayQmerge{
    private List<Integer> queue = new ArrayList<Integer>();

    public void enqueue(int val){
        queue.add(val);
    }

    public String toString(){
        return queue.toString();
    }

    public void mergeQs(ArrayQmerge q){
        List<Integer> mergedQ = new ArrayList<Integer>(this.queue.size() + q.queue.size());
        for (int i = 0, j = 0; i < this.queue.size() || j < q.queue.size();){
            if (i < this.queue.size())
                mergedQ.add(this.queue.get(i++));
            if (j < q.queue.size())
                mergedQ.add(q.queue.get(j++));
        }
        this.queue = mergedQ;
   }
}