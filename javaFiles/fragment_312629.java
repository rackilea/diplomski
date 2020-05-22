public static class Crumb {
    public String name;
    public String url;

    @Override
    public String toString(){
        return name + ":" + url;
    }
}