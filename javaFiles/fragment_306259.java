for(int i=0;i<students.length;i++){
            if(students[i] instanceof User) {
                System.out.println(students[i].getRollNumber());
                System.out.println(students[i].getName());
            }
        }