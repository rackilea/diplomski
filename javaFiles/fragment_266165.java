public class Matrix <TValue> {

    Object items = null;

    public <TContainer> Matrix(Class<TContainer> containerClass) throws Exception{       
        try{
            TContainer obj = containerClass.newInstance();

            if(obj instanceof ArrayList){
                items = new ArrayList<ArrayList<TValue>>();
            } else if(obj instanceof LinkedList){
                items = new LinkedList<LinkedList<TValue>>();
            }                                 
        }catch(Exception ie){
            throw new Exception("The matrix container could not be intialized." );
        }                       
        if(items == null){
            throw new Exception("The provided container class is not ArrayList nor LinkedList");
        }
    }


    public List<List<TValue>> getItems(){
        return (List<List<TValue>>)items;
    }


}