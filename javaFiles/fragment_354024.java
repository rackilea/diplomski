public void populateItem(final Item cellItem, final String componentId, final IModel model) {
                Long id = ((MyObject) model.getObject()).getId();
                String desc = ((MyObject) model.getObject()).getDescription();
                Label l = new Label(componentId, id + "");
                l.add(new PrototipBehaviour(desc));
                cellItem.add(l);

            }