chart.addListener(new PointClickListener() {
    @Override
    public void pointClick(PointClickEvent pointClickEvent) {
        Item item = pointItems.get(pointClickEvent.getPoint());

        Window popupWindow = new Window();
        // Add stuff to your window
        getWindow().addWindow(popupWindow);
    }
});