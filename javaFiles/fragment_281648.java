public class Foo {

    private String A;
    private boolean b;//??

    public boolean isAValid (String a) {
        int aLength = a.length();
        return b = (aLength==9) ? true: false;//why do you set b?
        //proposal: change to
        return (alength == 9);//and don't set b
    }

    public void setA(String A) throws AInvalidException{
        if(isAValid(A)) {
            this.A = A;
        } else {//add else, otherwise you will always throw an exception
            throw new AInvalidException();
        }
    }

    //...


}