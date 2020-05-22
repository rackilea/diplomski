public class Old{
    protected Old old;
    protected List stuff;

    //Needed for JUnit
    public Old(){
    }

    //Here's my new copy constructor.
    public Old(Old old){
        this.stuff=new ArrayList(old.getStuff());
        this.old=null;
    }

    public Old(List stuff){
        this.stuff=stuff;
        old=new Old(this);//Here I now call the copy constructor.
    }

    public void add(){
        stuff.add(2);
    }

    public void match(){
        System.out.printf("old:%d\nnew:%d\n",old.getStuff().size(),stuff.size());
    }

    public List getStuff(){
        return new ArrayList(stuff);
    }

    @Test
    public void testOld(){
        List list=new ArrayList();
        list.add(1);
        Old thing=new Old(list);
        thing.add();
        thing.match();
    }
}