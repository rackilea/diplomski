List<Object[]> list = new ArrayList<Object[]>();        
Object[] ob = new Object[4];
ob[0] = "user1";
ob[1] = "messge1";
ob[2] = "user2";
ob[3] = "time1";

list.add(ob);       

ob = new Object[4];
ob[0] = "user2";
ob[1] = "messge2";
ob[2] = "user4";
ob[3] = "time2";
list.add(ob);

// Output the values
for(Object[] o : list){
    System.out.print(o[0] + "\t");
    System.out.print(o[1] + "\t");
    System.out.print(o[2] + "\t");
    System.out.print(o[3] + "\n");
}