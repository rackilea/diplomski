public static Date parse(String date) throws Exception {

    try{

        List<DateGroup> parse = new PrettyTimeParser().parseSyntax(date);
        return parse.get(0).getDates().get(0);

    }catch (Exception e){
        throw new Exception("unparseable date: " + date);
    }

}