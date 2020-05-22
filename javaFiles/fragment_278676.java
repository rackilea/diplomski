public static void main(String[] args) {
    List<String>  listStr = Arrays.asList("A","B","C");
    List<Integer> listInt = Arrays.asList(1,2,3);
    printList(listStr);
    printList(listInt);

}

private static void printList(List<?> list) {
    for(Object obj : list){
        if(obj instanceof String){
            String str = (String) obj;
            System.out.printf("String: %s \n", str);
        } else if(obj instanceof Integer){
            Integer integer = (Integer) obj;
            System.out.printf("Integer: %s \n", integer);
        }

    }

}