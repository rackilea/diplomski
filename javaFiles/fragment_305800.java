@Override
    public Ville select(int id) {
        // TODO Auto-generated method stub
        Ville v = (Ville)sf.openSession().get(Ville.class, id);
        return v;
    }