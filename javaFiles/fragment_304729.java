@JsonCreator
        public static ProcessState factory(String inputValue) {

        if(inputValue.length() == 1){

            for(ProcessState type : ProcessState.values()){
                if(inputValue.equals(type.getValue().substring(0,inputValue.length()))){
                    return type;
                }
            }
        }


        return ProcessState .valueOf(inputValue);
}