public <T> List<T> execute(String name, Map<String, Object> params, List<T> type) {
    List<Object> emps = new ArrayList<Object>();
    emps.add(new Employee());
    //emps object will be generated dynamically
    return (List<T>) emps;
}