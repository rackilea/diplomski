interface Lang {

}

class EN implements Lang {

}

class FR implements Lang {

}

<%
  String language = "EN";
  Lang lang;
  if (language.equals("EN")){
    lang = new EN();
  }
  else if (language.equals("FR")){
    lang = new FR();
  }
%>