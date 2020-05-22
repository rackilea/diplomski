public static void main(String args[]) throws Exception {
        String expression = "(OPVAL == 'OPERATION') && (DAT > '12345')";
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("OPVAL", "OPERATION1");
        vars.put("DATA", "0");
        System.out.println(MVEL.eval(expression, vars));
    }