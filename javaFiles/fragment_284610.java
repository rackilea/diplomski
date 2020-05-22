public static class LinkedDeque<T> {

        private int count;
        private LinearDoubleNode<T> firstNode, lastNode;

        // constructor
        public LinkedDeque(){

            count = 0;
            firstNode = null;
            lastNode = null;

        } // end of constructor

        // Beginning of enqueueFront
        public void enqueueFront(T element) {
            LinearDoubleNode newNode = new LinearDoubleNode();
            newNode.setElement(element);
            if(isEmpty()){

                lastNode = newNode;
                firstNode = newNode;
            }
            else {
                LinearDoubleNode second=firstNode;
                firstNode=newNode;
                firstNode.setNext(second);
                second.setPrev(firstNode);
               // firstNode.setPrev(newNode);

            }

            count++;

        } // end of enqueFront

        // Beginning of enqueueBack
        public void enqueueBack(T element) {
            if (element==null) throw  new NullPointerException("cannot add null to the list");

            LinearDoubleNode<T> node = new LinearDoubleNode<T>(element);
            node.setElement(element);
            if (isEmpty()){
                firstNode = node;
                lastNode=node;}
            else{
                LinearDoubleNode<T> before=lastNode;
                lastNode=node;
                before.setNext(lastNode);
                lastNode.setPrev(before);
            }


            count++;

        } // end of enqueueBack

        // Beginning of dequeueFront
        public T dequeueFront() {

            T front = null;
            if (count==1){
                front=firstNode.getElement();
                firstNode=null;
                lastNode=null;
                count--;
            }
            else if (!isEmpty()) {
                count--;
                front = firstNode.getElement();
                firstNode = firstNode.getNext();
            }

            return front;

        } // end of dequeueFront

        // Beginning of dequeueBack
        public T dequeueBack() {

            T back = null;
            if (count==1){
                back = lastNode.getElement();
                lastNode = null;
                firstNode = null;
                count--;
            }
             else if (!isEmpty()) {
                count--;
                back = lastNode.getElement();
                lastNode = lastNode.getPrev();
                lastNode.setNext(null);
            }
            return back;

        } // end of dequeueBack()

        public T first() {
            return firstNode.getElement();
        }

        public T last() {
            return lastNode.getElement();
        }

        // Beginning of isEmpty()
        public boolean isEmpty() {

            return count==0;

        } // End of isEmpty()

        // Beginning of size()
        public int size() {
            return count;
        }

        // Begin of toString() method
        public String toString() {

            if (isEmpty()) {
                return " ";
            }

            StringBuilder sb = new StringBuilder();
            LinearDoubleNode<T> next = firstNode;

            while(next != null){
                sb.append(" ").append(next.getElement());
                next = next.getNext();
            }

            return sb.toString();

        } // End of toString()

    } // End of LinkedDeque

} // End of class header

    DEQUE TESTING
The size of the deque is: 3
The deque contains:
 4 9 8
4
8
9
1
11
The size of the deque is: 2
The deque contains:
 11 1