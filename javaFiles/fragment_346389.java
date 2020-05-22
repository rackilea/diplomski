public static final JSONObject MYOBJ = new JSONObject(){
    {
        try {
            put("value", "expression");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
};