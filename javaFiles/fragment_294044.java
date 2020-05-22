public SOExample() {
    initComponents();
    addText("This is my plain text", null);

    //Retrieve existing attributes.
    SimpleAttributeSet previousAttribs = new SimpleAttributeSet
                                             (jtp.getInputAttributes()
                                                 .copyAttributes());

    SimpleAttributeSet BOLD = new SimpleAttributeSet();
    StyleConstants.setBold (BOLD, true);
    StyleConstants.setForeground (BOLD, Color.BLUE);

    //Merge new attributes with existing ones.    
    previousAttribs.addAttributes (BOLD);

    //Insert the string and apply merged attributes.
    addText ("This is my BLUE BOLD text", previousAttribs);

    outputHTMLfile();