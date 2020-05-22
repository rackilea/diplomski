public static void main(String[] args) {
    List<String[]> data = Arrays.asList(new String[][] {
            {"name","sname","Id1","Id2","type","LDP","oldvalue","newvalue"},
            {"test1","abc","20","50","t1","SD1","0","1"},
            {"test2","znc","21","23","t1","SF5","3","4"},
            {"test1","abc","20","50","t1","SD3","0","1"},
            {"test1","HJc","53","50","t1","SD3","0","1"},
            {"test2","znc","21","23","t1","SF1","1","6"},
            {"test1","abc","20","50","t1","SD5","2","19"},
            {"test3","ldb","19","54","t1","SR51","6","1"},
            {"test2","znc","21","23","t1","SF12","17","36"},
            {"test3","ldb","19","54","t1","SR44","19","31"},
            {"test4","lYI","76","56","t1","TB77","54","87"}
    });

    aggregate(data)
            .stream()
            .map(Arrays::toString)
            .forEach(System.out::println);
}