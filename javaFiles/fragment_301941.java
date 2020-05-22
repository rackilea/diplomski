List<UriTemplate> matchedTemplates = uriInfo.getMatchedTemplates();

    StringBuilder builder = new StringBuilder();

    for (int i = matchedTemplates.size() - 1; i >= 0; i--) {
        builder.append(matchedTemplates.get(i).getTemplate().substring(1));
    }

    System.out.println("Permission is: " + builder.toString());
   // Prints:
   // Permission is: sig/companies/{id}