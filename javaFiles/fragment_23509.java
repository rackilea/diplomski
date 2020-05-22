//Inserting Skip Search
    public void insertInSkip(String SSN, String lName, String fName)
    {

        Node tmp = head;
//        System.out.println(tmp.first);
//        System.out.println(tmp.second);
//        System.out.println(tmp.third);
//        System.out.println(tmp.first.SSN);

        while((tmp != null) && (tmp.first.SSN != null) && SSN.charAt(0) >= tmp.first.SSN.charAt(0) ) // changed
        {
            tmp = tmp.first;
        }

        while((tmp != null) && (tmp.second.SSN != null) && SSN.charAt(1) >= tmp.second.SSN.charAt(1) ) // changed
        {
            tmp = tmp.second;
        }

        while((tmp != null) && (tmp.third.SSN != null) && SSN.charAt(2) >= tmp.third.SSN.charAt(2) ) // changed
        {
            tmp = tmp.third;
        }
        System.out.println("ssn="+SSN);
        System.out.println(tmp.fourth.SSN);
        if (tmp.fourth.SSN != null){  // changed
            System.out.println(SSN.compareTo(tmp.fourth.SSN));
        }

        while((tmp != null) && (tmp.fourth.SSN != null) && (SSN.compareTo(tmp.fourth.SSN) > 0)) // changed
        {
            tmp = tmp.fourth;
        }
        if(SSN.equals(tmp.SSN))
        {
                return;
        }
        else
        {
            Node temp = new Node(SSN, fName, lName);
            temp.fourth = tmp.fourth;
            tmp.fourth = temp;
        }
        endTimer();  
    }