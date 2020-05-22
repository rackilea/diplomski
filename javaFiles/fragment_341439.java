if(s.getLastName().compareTo(t.data.getLastName()) < 0) {
        if (t left == null) {
            t.left = new Node(s);
       } else {
            t.left = insert(s,t);  // insert using t as the new root 
       } 
       return t;  // return t with its new child