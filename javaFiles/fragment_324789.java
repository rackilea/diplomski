public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    list.add("PersonTwo - 5678 seconds");
    list.add("PersonOne - 1234 seconds");
    list.add("PersonOnedf - 34 seconds");

    System.out.println("Initial : " + list); 
    Collections.sort(list, new Comparator<Object>() {
           @Override
           public int compare(Object arg0, Object arg1) {
               String s1 = (String)arg0;
               String s2 = (String)arg1;
               Integer n1 = Integer.parseInt(s1.split("-")[1].trim().split(" ")[0]);
               Integer n2 = Integer.parseInt(s2.split("-")[1].trim().split(" ")[0]);
               return (n1 < n2 ? -1 : 1);
           }
       });

     System.out.println("Sorted : " + list);

}