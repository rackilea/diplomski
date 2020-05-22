final ColumnGenerator generator = new ColumnGenerator() {
            private static final long serialVersionUID = 1L;

            @Override
            public Component generateCell(Table source, final Object itemId, Object columnId) {
                final HorizontalLayout layout = new HorizontalLayout();
                layout.setSizeFull();

                Embedded icon1 = new Embedded();
                Embedded icon2 = new Embedded();
                Embedded icon3 = new Embedded();

                //Add some themeresource to embedded components

                //Do some listners to this icons

                layout.addComponent(icon1);
                layout.addComponent(icon2);
                layout.addComponent(icon3);

                //Set column with
                setColumnWidth(columnId, 100);

                return  layout;
                }
            };