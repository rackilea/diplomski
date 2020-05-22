Attributes attrs = new Attributes();
    List<String> attribValues = new ArrayList<String>();
    System.out.println();
    if (attrs.get("department") != null
            && attrs.get("telephonenumber") != null) {
        System.out
                .println(attrs.get("department") + " " + attrs.get("name")
                        + " " + attrs.get("Description") + " "
                        + attrs.get("mail") + " "
                        + attrs.get("telephonenumber")
                        + attrs.get("samaccountname")
                        + attrs.get("samaccountname"));
        attribValues.add(attrs.get("department"));
        attribValues.add(attrs.get("telephonenumber"));
    }

    final String[] attribArray = attribValues.toArray(new  String[attribValues.size()]);