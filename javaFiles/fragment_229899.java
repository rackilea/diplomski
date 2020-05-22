if (s.contains("<td>"))
    {
        String first = s.substring(0, s.indexOf("<td>"));
        String last = s.substring(s.indexOf("<td>"), s.indexOf("</td>") + 5);

        System.out.println("result  : "+first + last.replace("**", ""));
    }
    else
    {
        System.out.println("result : "+s);
    }