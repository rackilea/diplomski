public static void main(String[] args) {
    // TODO Auto-generated method stub


    ArrayList<String> a1=new ArrayList<>();
    ArrayList<String> b1=new ArrayList<>();
    ArrayList<String> c1=new ArrayList<>();
    a1.add("a1");
    a1.add("a2");
    a1.add("a3");

    b1.add("b1");
    b1.add("b2");

    c1.add("c1");
    c1.add("c2");

    for(int j=0;j<a1.size();j++)
    {
        System.out.println("finding thestuuf from arralist to use in your excel cells"+">>>"+a1.get(j)+">>>"+b1.get(j)+">>>"+c1.get(j));
    }

}