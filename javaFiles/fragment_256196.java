System.out.print("Select student by ID: ";
int pickID = scan.nextInt();
boolean found = false;
for(Student s : someStudent){
    if(s.id == pickID && !found){
        update(s);
        found = true;
    }
}
if(!found){
    System.out.println("No student with that ID.");
}