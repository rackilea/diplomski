public enum LOOK_UP {
    BACKOFFICE_DEAFULT_RAPOR_DATE("BACKOFFICE_DEAFULT_RAPOR_DATE", LOOK_UP_OPTION.LAST_FINISHED_MSPOT_TRADING_DATE),
    BACKOFFICE_QUERY_TYPE("BACKOFFICE_QUERY_TYPE", LOOK_UP_OPTION.STATIC_QUERY_TYPE);
    private String name;
    public final LOOK_UP_OPTION option;
    private LOOK_UP(String name, LOOK_UP_OPTION option){
        this.name=name;
        this.option = option;
    }

     public String getName(){
         return  name;
    }

    public enum LOOK_UP_OPTION {
        LAST_FINISHED_MSPOT_TRADING_DATE(LOOK_UP.BACKOFFICE_DEAFULT_RAPOR_DATE ,"LAST_FINISHED_MSPOT_TRADING_DATE","LAST FINISHED MSPOT TRADING DATE"),
        STATIC_QUERY_TYPE(LOOK_UP.BACKOFFICE_QUERY_TYPE ,"STATIC_QUERY_TYPE","Static Query");

        LOOK_UP look_up;
        private String code;
        private String  label;

        //db miss match label and code
        private LOOK_UP_OPTION(LOOK_UP look_up , String code,String label){
            this.look_up=look_up;
            this.code=code;
            this.label=label;
        }
    }
}