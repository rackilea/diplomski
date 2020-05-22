public class AttributeForm {
    int sizes;

    public void setSizes(int sizes){
      this.sizes = sizes;
    }

    public void doSomething(){
      if(this.sizes > 1)
          System.out.println("Greater than one");
        else
          System.out.println("Less than one");
    }
  }