private String printList (Student [] list){
        String s = "";
        byte b;

        for (Student stud:list
             ) {
            s+=" \n\t" + stud.toString();
        }
        return s;
    }