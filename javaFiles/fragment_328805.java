public static void main(String[] args) {
        boolean cuSearch = false;
        boolean caseSearch = true;
        boolean cpSearch = true;
        boolean addressSearch = false;
        int e = ( ( toInt(cuSearch) * toInt(caseSearch) ) + (toInt(cpSearch) * toInt(addressSearch)) + (toInt(caseSearch) * toInt(addressSearch)) + (toInt(caseSearch) * toInt(cpSearch)) + (toInt(cuSearch) * toInt(addressSearch)) + (toInt(cuSearch) * toInt(cpSearch)) );
        boolean result=false;
        if(e == 1){
            result = true;
        }
        System.out.println(result);
    }

    static int toInt(boolean b) { 
        return b ? 1 : 0 ;
    }