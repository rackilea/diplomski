@RequestMapping(value="/checkOut",method = RequestMethod.POST)
 public String checkOut(@RequestParam("id")String userName){

 billable bill = new billable();
 bill.setBillableName(rName);
 bill.setBillableAddress(bAddress);

 User user = userService.getuserByName(userName);

 bill.setUser(user);

 Set<Item> s = (Set)user.getItem();

 Set<Item> items = new HashSet<Item>();
 for(Item i:s){

     System.out.println(i.getItemName());
     Item myItem = (Item)i;
     //I'm assuming your gonna actually do something here, not just loop for fun
     items.add(i);
 }
 bill.setItem(items);