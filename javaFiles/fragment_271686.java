class myItemCheckListener implements ActionListener{

    private InventoryTrackingSystem its;

    // constructor takes its instance as argument
    public myItemCheckListener(InventoryTrackingSystem its){
        // ...assigns it to the member variable
        this.its = its;
    }

    public void actionPerformed(ActionEvent ev){
        // call swapView on the correct instance of InventoryTrackingSystem
        its.swapView()
    }
}