class PageA {

    public PageA dosomethingA(){
        //some code
        return this;
    }

    public Popup<PageA> openPopup(){

        return new Popup<PageA>(this);
    }
}

class Popup<T> {

    private T caller;

    public Popup(T caller) {
        this.caller = caller;
    }

    public Popup<T> doSomething1(){
        //some code
        return this;
    }

    public Popup<T> doSomething2(){
        //some code
        return this;
    }   

    public Popup<T> doSomething3(){
        //some code
        return this;
    }   


    public T closePopup(){
        //some code
        return caller;
    }   
}