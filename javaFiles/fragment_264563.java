public static Comparator<UserConfigurationDto> BY_LASTNAME =  (u1, u2) -> {

        // first case
        if( u1.isLastAndFirstNameEmpty() && u2.isLastAndFirstNameEmpty()){
            return u1.getUsername().compareToIgnoreCase(u2.getUsername());
        }
        // second case
        if(u1.isLastAndFirstNameEmpty()){
            return 1;
        }
        else if(u2.isLastAndFirstNameEmpty()){
            return -1;
        }
        // third case
        String s1 = u1.getLastName().isEmpty() ? u1.getFirstName() : u1.getLastName();
        String s2 = u2.getLastName().isEmpty() ? u2.getFirstName() : u2.getLastName();
        return s1.compareToIgnoreCase(s2);
    };