String a = "abc";
        String b = "abc";

        // returns true because a and b points to same string object
        if(a == b){
            System.out.println("Strings are equal by == because they are cached in the string pool");
        }

        b = new String("abc");

        // returns false as now b isn't a string literal and points to a different object
        if(a == b){
            System.out.println("String literal and String created with new() are equal using ==");
        }else{
            System.out.println("String literal and String created with new() are not equal using ==");
        }

        //both strings are equal because their content is the same
        if(a.equals(b)){
            System.out.println("Two Strings are equal in Java using the equals() method because their content is the same");
        }else{
            System.out.println("Two Strings are not equal in Java using the equals() method because their content is the same");
        }