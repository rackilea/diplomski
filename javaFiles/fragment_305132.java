String conName;
List<String> conPhoneType;
List<String> conPhoneValue;
List<String> conEmailType;
List<String> conEmailValue;
List<ContactCardModel> listConCard = new ArrayList<ContactCardModel>();

int i = 1;

    for (AddressBookContact addressBookContact : list) {

        conName = addressBookContact.name;

        conPhoneType = new ArrayList<String>();
        conPhoneValue = new ArrayList<String>();
        if(addressBookContact.phones != null) {

            for (int x = 0; x < addressBookContact.phones.size(); x++) {
                int type = (int) addressBookContact.phones.keyAt(x);
                String typeName = (String) ContactsContract.CommonDataKinds.Phone.getTypeLabel(addressBookContact.res, type, "");
                String phValue = addressBookContact.phones.valueAt(x);

                conPhoneType.add(typeName);
                conPhoneValue.add(phValue);
            }
        }

        conEmailType = new ArrayList<String>();
        conEmailValue = new ArrayList<String>();
        if(addressBookContact.emails != null){

            for(int x = 0; x < addressBookContact.emails.size(); x++){
                int type = (int) addressBookContact.emails.keyAt(x);
                String typeName = (String) ContactsContract.CommonDataKinds.Phone.getTypeLabel(addressBookContact.res, type, "");
                String emailValue = addressBookContact.emails.valueAt(x);

                conEmailType.add(typeName);
                conEmailValue.add(emailValue);
            }
        }

        listConCard.add(new ContactCardModel(conName, conPhoneType, conPhoneValue, conEmailType, conEmailValue));

    }