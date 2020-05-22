@Override
    public void onResume() {
        super.onResume();
        if(switchToTab){
            bar.setSelectedNavigationItem(Utils.ORDER_STATUS_TAB_ID);
            switchToTab = false;
        }
     }