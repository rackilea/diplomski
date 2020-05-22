class SubAbstract extends MainAbstract{

    SubAbstract nSubAbs;

    SubAbstract(int iQty, String name, String type) {
        nSubAbs = new SubAbstract();
        this.nSubAbs.setiQty(iQty);
        this.nSubAbs.setsName(name);
        this.nSubAbs.setsType(type);
    }

    private SubAbstract() {
        //no arg constructor
    }

    @Override
    public void showInfo() {
        System.out.println("iQty:" + nSubAbs.getiQty());
        System.out.println("name:" + nSubAbs.getsName());
        System.out.println("type:" + nSubAbs.getsType());
    }
}