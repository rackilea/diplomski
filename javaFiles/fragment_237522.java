MemoryWarningSystem system = new MemoryWarningSystem();
    system.setPercentageUsageThreshold(0.8d);
    system.addListener(new Listener() {
        @Override
        public void memoryUsageLow(long usedMemory, long maxMemory) {
            System.out.println("low: "+usedMemory+" / "+maxMemory);
        }
    });