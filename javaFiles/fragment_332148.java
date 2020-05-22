public class ConvertEnumeration {

    public static void main(String [] args) {

        // int [] ourArray = {0,1,2,3,4,5,6,7,8,9};
        Vector<Integer> vector = new Vector<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

        //Get Enumerator 
        Enumeration<Integer> enumerator = vector.elements();

        EnumerationToIterator<Integer> enumToIt = new EnumerationToIterator<Integer>(enumerator);
        while(enumToIt.hasNext()) {
            System.out.println(enumToIt.next());
        }
    }

}    

//Convert our enumeration to Iterator!
    class EnumerationToIterator<T> implements Iterator<T> {

        //Our enumeration
        Enumeration<T> enmueration;

        //Constructor
        public EnumerationToIterator(Enumeration<T> enmueration){
            this.enmueration = enmueration;
        }

        //Our Methods
        public boolean hasNext(){
            return enmueration.hasMoreElements();
        }

        public T next(){
            return enmueration.nextElement();
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }