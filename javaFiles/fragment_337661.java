approversStore.addStoreListener(new StoreListener<Approver>() {
            @Override
            public void storeDataChanged(StoreEvent<Approver> se) {
                super.storeDataChanged(se);

                ListViewSelectionModel<Approver> approverListFieldSelectionModel = approversListField.getListView()
                        .getSelectionModel();
                approverListFieldSelectionModel.deselectAll();
                approversListField.getListView().setStore(approversListField.getStore());
                approversListField.getListView().refresh();
                for (int i = 0; i < approversListField.getStore().getCount(); i++) {                    
                    Approver app = approversListField.getStore().getAt(i);
                    if (app.getIsselected() == true) {                  
                        approverListFieldSelectionModel.select(i, true);

                    }
                }

            }
        });