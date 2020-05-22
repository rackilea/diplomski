VTDGen vtdGen = new VTDGen();
     vtdGen.selectLcDepth(5);
     vtdGen.parseFile("c:\\xml\\agata.xml",false);
     AutoPilot ap = new AutoPilot(),ap1=new AutoPilot(), 
ap2=new AutoPilot(),ap3=new AutoPilot();
     VTDNav vn = vtdGen.getNav();
     int i = -1;
     ap.bind(vn);ap1.bind(vn);ap2.bind(vn);ap3.bind(vn);
     ap.selectXPath("/MedlineCitationSet/MedlineCitation");
     ap1.selectXPath("PMID");
     ap2.selectXPath("DateCreated");
     ap3.selectXPath("Article");
     while ((ap.evalXPath()) != -1) {
            String year = null, day = null, month = null;
            i++;

           if (vn.hasAttr("Owner"))     System.out.println("Owner==>"+vn.toNormalizedString(vn.getAttrVal("Owner")));
                        //articlesList.get(i).setOwner(vtdNav.toNormalizedString(vtdNav.getAttrVal("Owner")));
                    if (vn.hasAttr("Status"))
                        System.out.println("Stats==>"+vn.toNormalizedString(vn.getAttrVal("Status")));
                        //articlesList.get(i).setStatus(vtdNav.toNormalizedString(vtdNav.getAttrVal("Status")));
                    vn.push();
                    while((ap1.evalXPath())!=-1){
                        System.out.println("Version==>"+vn.toNormalizedString(vn.getAttrVal("Version")));
                        System.out.println("PMID==>"+vn.toNormalizedString(vn.getText()));
                    }
                    ap1.resetXPath();
                    vn.pop();
                    vn.push();
                    while((ap2.evalXPath())!=-1){
                        vn.toElement(VTDNav.FIRST_CHILD,"Year");
                        System.out.println("Year==>"+vn.toNormalizedString(vn.getText()));
                        vn.toElement(VTDNav.PARENT);
                        vn.toElement(VTDNav.FIRST_CHILD,"Month");
                        System.out.println("Month==>"+vn.toNormalizedString(vn.getText()));
                        vn.toElement(VTDNav.PARENT);
                        vn.toElement(VTDNav.FIRST_CHILD,"Day");
                        System.out.println("Day==>"+vn.toNormalizedString(vn.getText()));
                        vn.toElement(VTDNav.PARENT);
                    }
                    ap2.resetXPath();
                    vn.pop();
                    VN.push();
                    while((ap3.evalXPath())!=-1){
                          System.out.println("PubModel==>"+vn.toNormalizedString(vn.getAttrVal("PubModel")));
                    VN.pop();   


      }