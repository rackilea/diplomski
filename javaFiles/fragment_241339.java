log.debug("Writing VCards to File: " + ExportFile.getAbsolutePath());
    FileWriter FW = new FileWriter(ExportFile);
    VCardWriter VCW = new VCardWriter(FW, VCardVersion.V2_1);
    VCard VC = null;
    StructuredName SN = null;
    Telephone T = null;


    Map<String, DataEntry> Properties = null;

    String homephone="";
    String phone="";
    String mobile="";
    String firstname="";
    String lastname="";     

    for(AddressbookContact AC : Addressbook)
    {
        log.debug("Writing: " + AC.getName());
        Properties = AC.getContactProperties();

        firstname=NameFilter(AC.getFirstname());
        lastname=NameFilter(AC.getFamilyname());

        if(firstname.isEmpty() && lastname.isEmpty())
        {
            firstname = AC.getCompany();
        }

        VC = new VCard();
        SN = new StructuredName();

        SN.setFamily(lastname);
        SN.setGiven(firstname);

        VC.setStructuredName(SN);

        homephone= Properties.get("homephone").getValue();      
        phone = Properties.get("phone").getValue();
        mobile= Properties.get("mobile").getValue();


        if(!homephone.isEmpty())
        {

            T = new Telephone(homephone);
            T.addType(TelephoneType.HOME);
            VC.addTelephoneNumber(T);
        }

        if(!phone.isEmpty())
        {
            T = new Telephone(phone);
            T.addType(TelephoneType.WORK);
            VC.addTelephoneNumber(T);
        }

        if(!mobile.isEmpty())
        {

            T = new Telephone(mobile);
            T.addType(TelephoneType.CELL);
            VC.addTelephoneNumber(T);
        }

        VCW.write(VC);
    }
VCW.close();