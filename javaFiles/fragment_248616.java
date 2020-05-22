public class SimpleBean implements Serializable {

    private ArrayList<Matrix> mats;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void setMats(ArrayList<Matrix> mats) {
        if(mats.equals(this.mats))
            return;
        ArrayList<Matrix> oldMats = this.mats ;
        this.mats = mats ;
        pcs.firePropertyChange("mats", oldMats, mats);
    }

    public ArrayList<Matrix> getMats() {
        return mats;
    }

    public void setMat(int index, Matrix mat) {
        Matrix existing = index == mats.size() ? null : mats.get(index);
        if(existing.equals(mat))
            return;
        mats.remove(index);
        mats.add(index, mat);
        pcs.fireIndexedPropertyChange("mats", index, existing, mat);
    }

    public Matrix getMat(int index) {
        return mats.get(index);
    }

    public void addMat(Matrix m) {
        setMat(mats.size(), m);
    }

}