new StringFilter("someValue") {
            @Override
            protected void fireUpdate() {
                super.fireUpdate();
                List<Component> items = menu.getItems();
                if (!items.isEmpty()) {
                    ((Field) items.get(0)).setValue("");
                }
// Not tested this. If the above code is not working try to get the 
textfield instance somehow from the menu and clear it 
            }

        };