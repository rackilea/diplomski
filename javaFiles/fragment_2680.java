abstract class base
{
       public void doSomething(base obj){
       }
}
class Child1 extends base
{
    public void somefunc(){
        doSomething(this);
    }
}
class Child2 extends base
{
    public void somefunc(){
        doSomething(this);
    }
}