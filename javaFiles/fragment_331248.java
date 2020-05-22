String str = ".calibre {"+
     "   background-color: white;"+
     "   display: block;"+
     "   font-family: Times New Roman;"+
     "   font-size: 1em;"+
     "   margin-bottom: 0;"+
     "   margin-left: 20pt;"+
     "   margin-right: 20pt;"+
     "   margin-top: 0;"+
     "   padding-left: 0;"+
     "   padding-right: 0;"+
     "   text-align: justify"+
     "   }";


     System.out.println(str.replaceAll("(margin|padding).+?;", ""));