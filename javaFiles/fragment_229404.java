public static void main(String... args) throws Exception{
    ArrayList<String> array=new ArrayList<String>(){

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            boolean isFirst=true;
            for(String s : this){
                if(!isFirst){
                    sb.append(",");
                }
                isFirst=false;
                sb.append("\""+s+"\"");
            }
            sb.append("]");
            return sb.toString();
        }
    };


    for (int i = 0; i < 5; i++) {
      array.add("someproduct");
    }
    System.out.println(array);


}