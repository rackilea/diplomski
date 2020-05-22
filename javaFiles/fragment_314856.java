class AClass {
    public float f;

    public AClass(float fstart) {
       f = fstart;
    }

    // TODO consider using List instead of ArrayList
    public void setf(ArrayList<? extends AClass> aList) {
       for(AClass ax : aList) f += ax.f;
    }
}

...

ArrayList<BClass> bList = new ArrayList<BClass>();
bList.add(b1);
bList.add(b2);
bList.add(b3);
a2.setf(bList);