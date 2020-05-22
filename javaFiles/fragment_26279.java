public static class Container{
    public int value = 0;
}

protected static Container setOne(){
    Container container = new Container();
    try{
        container.value  = 20;
        return container ;
    }finally{
        container.value  = container.value + 10;
    }
}