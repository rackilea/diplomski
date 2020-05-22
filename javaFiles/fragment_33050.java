class Holder {
    Map map1;
    Map map2;
}

class Reader {
    Holder holder;
    void read() {
        writer.getHolder().map1.get("x");
    }
}

class Writer {
    Holder holder;
    Holder getHolder() {
        return holder;
    }
    void reload() {
        Holder newHolder = new Holder();
        newHolder.map1 = createNewMap1WithLatestData();
        newHolder.map2 = createNewMap2WithLatestData();
        holder = newHolder; // this is atomic
    }
}