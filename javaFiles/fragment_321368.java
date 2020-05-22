@Override
    public int compare(final Environment o1, final Environment o2) {
        int order1=-1;
        int order2=-1;
        String remainder1="";
        String remainder2="";
        for (String prefix: customOrder){
            if (o1.getAcronym().startsWith(prefix)){
                order1=customOrder.indexOf(prefix);
                remainder1=o1.getAcronym().substring(prefix.length());
            }
            if (o2.getAcronym().startsWith(prefix)){
                order2=customOrder.indexOf(prefix);
                remainder2=o2.getAcronym().substring(prefix.length());
            }
        }
        if (order1==order2){
            return remainder1.compareTo(remainder2);
        }
        else{
            return order1-order2;
        }
    }