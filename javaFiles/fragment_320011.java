TextField drug = new TextField("drug");
drug.setMarkupId("drug_1"); // Make sure this ID is unique in the page!
drug.setOutputMarkupId(true);
add(drug);
Label drugDescription = new Label("drugSearchResult.row.item.label", aModel);
add(drugDescription);