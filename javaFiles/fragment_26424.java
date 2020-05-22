public static void main(String[] args) {

    //Orginal string, remove the loan tags
    String str="<loan><account>123456</account><name>RamaKrishna</name><principle>1000</principle><issue_date>Jan-1-2013</issue_date><interest_rate>12%</interest_rate></loan>";
    str = str.replace("<loan>", "");
    str = str.replace("</loan>", "");

    //Create an array of the string
    List<Character> list = new ArrayList<Character>();
    for(char c : str.toCharArray()) {
            list.add(c);
    }       

    //Result
    ArrayList<String> tmp = XmlComma(list);

}