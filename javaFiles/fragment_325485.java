2. for (String output : mylist) 
{
      System.out.println(output);
      mylist = new ArrayList<String>(); //It worked 
      mylist.add(output);
}