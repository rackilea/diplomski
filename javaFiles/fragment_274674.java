class SortingAlgorithm implements Observable{
    private ArrayList<Observer> observers;  //keep a list of observers for notifying
    //Other attributes and initializations not shown

    @Override
    public void register(Observer o){
        observers.add(o);       
    }

    @Override
    public void unregister(Observer o){
        observers.remove(o);
    }

    @Override
    public void notifyObservers(){
        for(Observer o : observers)
            o.update(list);  //Update all observers with your latest list updates
    }

    public void bubbleSort(){
        //Your sorting happens here..
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(intArray[j-1] > intArray[j]){
                    //swap the elements!
                    temp = intArray[j-1];
                    intArray[j-1] = intArray[j];
                    intArray[j] = temp;

                    //Notify GUI to update screen
                    notifyObservers();
                }    
            }
        }
    } 
}