public interface MyPublicInterface {

}

interface MyDirectInterface extends MyPublicInterface {

}

class MyImpl implements MyDirectInterface {

    public void add(MyPublicInterface mpi) {
         MyDirectInterface mdi = (MyDirectInterface) mpi;
         // use mdi
    }

}