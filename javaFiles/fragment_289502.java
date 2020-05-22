List<Category> categories = new ArrayList();
while (in.hasNextLine()) {
    String catName = in.readLine();
    if (catName.trim().length() == 0)
        continue;   // skip extra blank lines between Sections.
    Category cat = new Category( catName);
    categories.add( cat);

    while (in.hasNextLine()) {
        String line = in.readLine();
        if (line.trim().length() == 0)
            break;   // end of Section.

        // parse a Question & it's Answer.
        TriviaQuestion question = parseQuestion( line);
        cat.addQuestion( question);
    }
}

// done.
return categories;