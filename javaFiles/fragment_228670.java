public class Obj{
    final int ID;
    String desctiption, name;
            public Obj(int _ID){
                    ID=_ID;
            }

    /**
     * @return the iD
     */
    public int getID() {
        return ID;
    }
    /**
     * @param iD the iD to set
     */
    public void setID(int iD) {
        ID = iD;
    }
    /**
     * @return the desctiption
     */
    public String getDesctiption() {
        return desctiption;
    }
    /**
     * @param desctiption the desctiption to set
     */
    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }



}