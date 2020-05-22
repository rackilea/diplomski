public static void main(String[] args) {

    String str = "{\"departments\":[20,22]}";
    JSONObject jsonObject = JSONObject.fromObject(str);
    Bar bar =  (Bar) JSONObject.toBean(jsonObject, Bar.class);
    List departments = bar.getDepartments();
    Long i=  Long.valueOf(departments.get(0).toString());
    System.out.println(i);
    System.out.println(departments.get(0).getClass().getName());

}