class Test{
    public static Object[] getWorkandPlay(ArrayList al) {
        ArrayList work = new ArrayList();
        ArrayList play = new ArrayList();

        for (int i=0; i<al.size(); i++){
            String item = (String) al.get(i);

            if (item.startsWith("w.")) {
                System.out.println("w " + item);
                work.add(item);
            } else if (item.startsWith("p.")) {
                System.out.println("p " + item);
                play.add(item);
            } else {
                System.out.println("Entries must start with either w. or p.\n");
            }
        }
        return new Object[] {work, play};
    }
    public static void main(String[] args) {
        ArrayList<String> al=new ArrayList<>();
        al.add("w. test");
        al.add("p. test");
        Object[] obj=getWorkandPlay(al);
        ArrayList setWork = (ArrayList)obj[0];
        ArrayList setPlay = (ArrayList)obj[1];
    }
}