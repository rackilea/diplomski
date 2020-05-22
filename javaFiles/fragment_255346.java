class Ideone
{
    List<Integer> list;

    public static void main (String[] args) throws java.lang.Exception
    {
        try {
            Ideone id = new Ideone();
            id.list = new ArrayList<Integer>();
            id.list.add(1);
            id.list.add(2);

            Ideone copyId = new Ideone();
            copyId.list = new ArrayList<Integer>();
            copyId.list.addAll(id.list);

            Ideone npeId = new Ideone();
            npeId.list.add(id.list);      //->nullpointerexception

        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}