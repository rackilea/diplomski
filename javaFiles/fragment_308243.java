HashMap<String,Employee> map = new HashMap<String,Employee>();

Employee e1=new Employee("1001","Rahul", "Gupta", "agupta");
Employee e2=new Employee("1002","Bijay", "Gupta", "bjay");

map.put(e1.getEno(), e1);
map.put(e2.getEno(), e2);
for (Map.Entry<String, ArrayList<Employee>> entry : map.entrySet()) {

    String key = entry.getKey();

    Employee value = entry.getValue();

    System.out.println("Key = " + key);

    System.out.println("Values = " + value.getEno() + " "+ value.getFname()+" "+value.getLname()+" "+getEmailid());

}