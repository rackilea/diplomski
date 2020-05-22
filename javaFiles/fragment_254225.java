Service<Void> readValDaemon = new Service<Void>() {
    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            public Void call() {
                //This functions reads from memory and writes the JSON
                readDataHI(connection,commandListHI,statusHI);
                return null;
            }
        };
    }
};