myMethod(() -> object.getList().get(0).getSomeObject.getName());

public void myMethod(Supplier<String>){
    try {
        String name = elo.get();
    }catch (Exception e){
        // do something
    }
}