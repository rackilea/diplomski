public Link searchStudent(int key) { 
    Link temp = cursor;
    int idNumber = 0;

    if(size >= key) {
        System.out.println("Ready to Search...");       
        for(int i = 0; i < size; i++) {

            System.out.println("key -> " + key);
            System.out.println(" id -> " + temp.getId());

            idNumber = Integer.parseInt(temp.getId());
            if(idNumber == key) {
                System.out.println("You found it!");
                break;
            } else {
                // Here!
                temp = temp.next;
            }
        }

    }
    return temp;        
}