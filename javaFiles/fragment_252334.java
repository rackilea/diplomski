public class CustomResponse<T> {
    private T userObject;
    private String Attributes;
    private String Tags;

    //a setter...
    public void setUserObject(T object) {this.userObject = object;}
    public T getUserObject() {return this.userObject;}
}