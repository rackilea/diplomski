interface DataSourceForTheGui {
    int getNum();
}

class Logic implements DataSourceForTheGui {
    int getNum() {
        return n;
    }
}

class GUI {
    private readonly DataSourceForTheGui data;
    public GUI(DataSourceForTheGui data) {
        this.data = data;
    }
    public void display() {
        int k = data.getNum();
    }
}