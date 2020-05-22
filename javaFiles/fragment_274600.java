public String processMe(HttpServletRequest request, HttpServletResponse response) throws SomeException {

    String[] values = validate(request,Number,Date);

    System.out.println(values[0]);//values[0] will contain the Number
    System.out.println(values[1]);//values[1] will contain the Date
}