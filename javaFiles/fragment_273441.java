public static void main(String[] args) {
    // TODO Auto-generated method stub          

    String [] a = {"america", "bakrain", "canada"};
    String [] b = {"denmark", "europe" };
    try{
        List<String> listString = new ArrayList<String>(Arrays.asList(a));
        listString.addAll(Arrays.asList(b));

        System.out.println(listString);
        String [] outResult= new String[listString.size()];

        int i=0;
        for(String str: listString){
            outResult[i]=str;
            i++;
        }


    } catch (Exception e) {
        e.printStackTrace();
    }    


}