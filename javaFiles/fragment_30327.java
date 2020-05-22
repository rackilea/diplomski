while (true) {
    for (int i = 0;i < testList.size(); i++) {
        Test test = testList.get(i);
        if (test.closed == true && !test.inUpdateThread) {
            test.inUpdateThread = true;
            UpdateThread urt = new UpdateThread(some other constructor here);
            new Thread(urt).start();
        }; 

    };
};