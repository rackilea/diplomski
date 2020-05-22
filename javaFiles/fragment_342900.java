public static void main(String[] args) throws Exception {
        List<String> strings = new ArrayList<String>();
        strings.add("jora string");
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(345);
        Object[] objs = new Object[]{strings,ints};
        for (Object obj : objs){
            if (isListInstanceOf(obj, String.class)){
                List<String> strs = castListTo(obj, String.class);
                for (String str : strs){
                    System.out.println(str);
                }
            }else if (isListInstanceOf(obj, Integer.class)){
                List<Integer> inList = castListTo(obj, Integer.class);
                for (Integer integ : inList){
                    System.out.println("Int: "+integ);
                }
            }
        }
    }


    public static boolean isListInstanceOf(Object list, Class clazz){
        return (list instanceof List && ((List)list).size() > 0) ? ((List)list).get(0).getClass().isAssignableFrom(clazz) : false;
    }

    public static <T> List<T> castListTo(Object list, Class<T> clazz){
        try{
            return (List<T>)list;
        }catch(ClassCastException exc){
            System.out.println("can't cast to that type list");
            return null;
        }
    }