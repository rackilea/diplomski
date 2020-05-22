pageTree = varname.getDoc().requirePages();

page = pageTree.getPage(index);

trimBox = page.getTrimBox().getValues();

height = trimBox[4] - trimBox[2];

width = trimBox[3] - trimBox[1];