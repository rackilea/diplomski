List<String> list1 =new ArrayList(Arrays.asList(new String[]{"APPROVE", "APPROVE", "CARVEOUT", "DENY", "CARVEOUT"}));
List<String> list2 =new ArrayList(Arrays.asList(new String[]{"APPROVE", "APPROVE", "CARVEOUT", "DENY"}));

for(String str:list2)
    list1.remove(new String(str));

System.out.println(list1);