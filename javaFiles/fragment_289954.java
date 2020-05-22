public class Boards<E> {

    public List<E> ids = new ArrayList<E>();

    //region GETTERS-SETTERS
    public void setIds(ArrayList<E> temp){
        this.ids = temp;
    }
    public List<E> getIds(){
        return ids;
    }
//    endregion
}