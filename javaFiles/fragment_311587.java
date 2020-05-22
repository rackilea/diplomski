table.addGeneratedColumn("generated", new ColumnGenerator() {

        @Override
        public Component generateCell(Table source,
                    final Object itemId, Object columnId) {
            Button button = new Button("caption");
            //Listener for the button
            button.addClickListener(Event -> {
                //Your code
            });
            return button;
        }          
});