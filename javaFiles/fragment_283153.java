private void createContent(Container main){
    String[]                            rows,cols;                                  // row/column specification arrays

    JPanel                              phnpnl,cszpnl,btnpnl;                       // special nested panels

    // create components here...

    // CREATE MAIN PANEL WITH DESIRED ROWS AND COLUMNS
    rows=MatrixLayout.arrayOf(10,"Size=Pref CellAlign=Middle CellInsets=5,0");   // standard row spec
    rows[6]                     ="Size=100% CellAlign=Top    CellInsets=5,0";    // note: row 7 ([6] is index)
    rows[7]                     ="Size=Pref CellAlign=Top    CellInsets=5,0";    // note: row 8 ([7] is index)
    rows[8]                     ="Size=Pref CellAlign=Top    CellInsets=5,0";    // note: row 9 ([8] is index)
    cols=MatrixLayout.arrayOf(3 ,"size=Pref CellAlign=Right  CellInsets=5,0");   // standard column spec
    cols[1]                     ="Size=50%  CellAlign=Left   CellInsets=5,0";    // note: col 2 ([1] is index)
    cols[2]                     ="Size=50%  CellAlign=Left   CellInsets=5,0";    // note: col 3 ([2] is index)
    con.setLayout(new MatrixLayout(rows,cols,"Row=Cur Col=Next"));

    // CREATE SPECIAL NESTED PANELS
    phnpnl=MatrixLayout.singleRowBar(5,false,new DctComponent[]{phnPart1,phnPart2,phnPart3                                   });
    cszpnl=MatrixLayout.singleRowBar(5,1    ,new DctComponent[]{city,createLabel("State"),state,createLabel("Zip"),zip,zipext});
    btnpnl=MatrixLayout.singleRowBar(5,true ,new DctComponent[]{yes,no,cancel                                                });
    phnpnl.setName("PhonePanel");
    cszpnl.setName("CityStateZipPanel");
    btnpnl.setName("ButtonPanel");

    // ADD COMPONENTS TO MAIN PANEL
    con.add(createLabel(   "Name :"),"row=Next col=1"); con.add(name    ,"               hAlign=Fill  hSpan=2                               ");
    con.add(createLabel("Address :"),"row=Next col=1"); con.add(address1,"               hAlign=Fill  hSpan=2                               ");
                                                        con.add(address2,"Row=Next Col=2 hAlign=Fill  hSpan=2                               ");
                                                        con.add(address3,"Row=Next Col=2 hAlign=Fill  hSpan=2                               ");
    con.add(createLabel(   "City :"),"row=Next col=1"); con.add(cszpnl  ,"                            hSpan=2                               ");
    con.add(createLabel(  "Phone :"),"row=Next col=1"); con.add(phnpnl  ,"                            hSpan=2                               ");
    con.add(createLabel(  "Notes :"),"row=Next col=1"); con.add(notes1  ,"Row=Cur  Col=2 hAlign=Fill          vAlign=Fill                   ");
                                                        con.add(notes2  ,"Row=Cur        hAlign=Fill          vAlign=Fill                   ");
                                                        con.add(notes3  ,"Row=Next Col=2 hAlign=Left                      hGroup=NoteButtons");
                                                        con.add(notes4  ,"Row=Cur        hAlign=Right                     hGroup=NoteButtons");
    con.add(btnpnl                  ,"row=Next col=1 hAlign=Right hSpan=3");
    main.setBorder(new DctEmptyBorder(10));
    main.setBackground(SystemColor.window);
    }