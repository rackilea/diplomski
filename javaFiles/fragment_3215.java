public void invokePush() {
    pushListener = new ActionListener() {
        public void actionPerformed(ActionEvent act) {
            int currentSize = (int)myStack.size();
            try {
                if (currentSize == ceiling) {
                    stackAppletInstance.ceilingReached();
                } else if (currentSize == ceiling - 1) {                        
                    stackAppletInstance.ceilingAlmostReached();
                } else if (currentSize == 0) {
                    stackAppletInstance.stackEmpty();
                }
            } catch (Exception e) {
                e.printStackTrace();  // ***** never leave this blank!
            }
        }
    };
    stackAppletInstance.addPushListener(pushListener);
}