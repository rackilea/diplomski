Counter c = new Counter() {
    public int count() {
        int lastCount = 0;
        for (int i = super.count(); --i >= 0; ) {
            lastCount = super.count();
        }

        return lastCount;
    }
}

c.count(); // Now double count