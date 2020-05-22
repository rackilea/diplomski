public void update(Student s){
    boolean edit = true;
    while(edit){
        System.out.println(String.format("Select operation:\n1. Change name\n2. Change ID\n3. Change CGPA\n4. Delete\n5. Done"));
        int opt = scan.nextInt();
        switch(opt){
            case 1:
                String newName = scan.next();
                s.setName(newName);
                break;
            case 2:
                int newID = scan.nextInt();
                s.setID(newID);
                break;
            case 3:
                float newCGPA = scan.nextFloat();
                s.setCGPA(newCGPA);
                break;
            case 4:
                for(int i=0;i<someStudent.length();i++){
                    if(someStudent.get(i)==s){
                        someStudent.remove(i);
                    }
                }
                break;
            case 5:
                edit = false;
                break;
            default:
                break;
        }
    }
}