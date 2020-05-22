picker.setListener(new BubblePickerListener() {
    @Override
    public void onBubbleSelected(@NotNull PickerItem item) {

        if (item.getTitle() != null) {
            switch(item.getTitle()) {

                case "item1":
                    // start activity of item1 
                    break;

                case "item2":
                    // start activity of item2
                    break;

                case "item3":
                    // start activity of item3
                    break;
            }

        }
    }

    @Override
    public void onBubbleDeselected(@NotNull PickerItem item) {

    }
});