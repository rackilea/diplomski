......

    public String getCenter()  {
        return mcenter;
    }

    public static void main(String[] args){
        country Turkey = new country(16, 7, "No");
        country France = new country(22, 4, "No");
        country England = new country(17, 9, "No");
        country Germany = new country(26, 4, "Yes");
        country Austria = new country(28, 1, "Yes");
        country Italy = new country(17, 8, "Yes");
        country Russia = new country(23, 3, "No");
        ArrayList<country> countries = new ArrayList<country>();
        countries.add(Turkey);
    }
}