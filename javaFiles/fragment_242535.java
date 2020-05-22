AcroFields form = stamper.getAcroFields();
    form.setGenerateAppearances(true);
    form.setField("name", "Bruno Lowagie" + i);
    form.setField("adress", "ADDRESS");
    form.setField("dates", "January 1, 2010");
    form.setField("titles", "blah blah blah");
    stamper.setFormFlattening(true);