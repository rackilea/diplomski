if (o1.company == null && o2.company == null) return 0;   

        if (o1.company != null && o2.company == null) return -1;
        if (o1.company == null && o2.company != null) return 1;

        return o1.company.compareTo (o2.company);    
    }
};