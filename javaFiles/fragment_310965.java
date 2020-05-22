"/CountryListCheck":
    String term = request.getParameter("term");
    System.out.println("Data from ajax call " + term);
                    ArrayList<String> list = new Op_contact(dcon).getAllCountriesCheck(term);
                    System.out.println(list);
                     Json = new Gson().toJson(list);
                   response.getWriter().write(Json );