class Test
{
    public static void main (String[] args)
    {
        String[] vals = {"A-1111","B-2222","C-3333"};
        ArrayList<Integer> result = new ArrayList<>();
        for(String val:vals)
        {
            result.add(Integer.parseInt(val.split("-")[1]));
        }
        //'result' is the List holding the integer parts
        System.out.println("Numeric parts are : " + result);
    }
}