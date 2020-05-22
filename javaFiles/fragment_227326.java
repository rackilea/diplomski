realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Bill updateBill = realm.where(Bill.class).equalTo("Bill_ID", bill).findFirst();
                    DetailMenu menu = new DetailMenu();
                    RealmList<PersonInMenu> personInMenus = new RealmList<>(); //added line
                    menu.personInMenus = personInMenus; //added line
                    menu.setMenuID(MenuID);
                    menu.setMenuName(String.valueOf(menuName.getText()));
                    menu.setMenuPrice(Price);
                    menu.setQuantity(Qty);
                    for (int i = 0; i < adapter.getPersonMenuObjList().size(); i++) {
                        PersonInMenu pim = new PersonInMenu();
                        pim.setPersonID(adapter.getPersonMenuObjList().get(i).getPersonID());
                        pim.setStatus(adapter.getPersonMenuObjList().get(i).isStatus());
                        menu.personInMenus.add(pim);
                    }

                    updateBill.detailmenu.add(menu);
                    realm.copyToRealmOrUpdate(updateBill);
                }
            });