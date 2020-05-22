class MyData{
    private int timeSpentSleeping;

    public int getTimeSpentSleeping() {
        return timeSpentSleeping;
    }

    public void setTimeSpentSleeping(int timeSpentSleeping) {
        this.timeSpentSleeping = timeSpentSleeping;
    }

    @NonNull
    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    static MyData build(final int timeSpentSleeping){
        MyData newInstance = new MyData();
        newInstance.timeSpentSleeping = timeSpentSleeping;
        return newInstance;
    }
}