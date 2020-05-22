public static void main (String[] args) 
{
    /* You can also make it global; depending on your needs */
    Set<String> office = new HashSet<>();
    String key = "A12-London_F6_R121";

    if(office.contains(key)) {
        System.out.println("Already Taken!");
    } else {
        office.add(key);

        /* Create New Office Object & Initialize it */
        Office off = new Office();
        off.setBuilding("A12-London");
        off.setFloor("F6");
        off.setRoom("R121");

        /* Set it back to Employee Object */
        /* I'm assuming you have some Employee Object named emp */
        emp.setOffice(off);

        System.out.println("Added Successfully!");
    }
}