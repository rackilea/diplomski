public class SortUserDefinedObjectUsingAnonymousComparator {

    public static void main(String[] args) {
        ArrayList<Employee> arrayList=new ArrayList<Employee>();
        arrayList.add(new Employee("Kamal", 20, 567));
        arrayList.add(new Employee("Doui", 50, 464));
        arrayList.add(new Employee("Buck", 90, 123));
        arrayList.add(new Employee("Auot", 100, 3445));


        for (Employee employee : arrayList) {
            System.out.println("ID:"+employee.getId()+" ,name:"+employee.getName());
        }

        Collections.sort(arrayList,new Comparator<Employee>() {

            public int compare(Employee empl1, Employee empl2) {

                if (empl1.getId()>empl2.getId()) {
                    return 1;
                }

                else if (empl1.getId()<empl2.getId()) {
                    return -1;
                }

                else {
                    return 0;
                }
            }
        });

        System.out.println("\n-------------------After Sort-------------------\n");
        for (Employee employee : arrayList) {
            System.out.println("ID:"+employee.getId()+" ,name:"+employee.getName());
        }

    }

}