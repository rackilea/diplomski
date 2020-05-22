public class ArrayListWithNicePrint<E> extends ArrayList{


        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            boolean isFirst=true;
            for(Object s : this){
                if(!isFirst){
                    sb.append(",");
                }
                isFirst=false;
                sb.append("\""+s.toString()+"\"");
            }
            sb.append("]");
            return sb.toString();
        }

    }