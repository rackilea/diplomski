public interface Foo{
    default int getBazModified(){
       return this.getBaz() * 2; 
    }

    int getBaz();
}