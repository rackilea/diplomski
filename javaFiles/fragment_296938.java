public class Maths {

    private ArrayList<Mathematician> mathematicians;

    /**
     * @return the mathematicians
     */
    public ArrayList<Mathematician> getMathematicians() {
        return mathematicians;
    }

    /**
     * @param mathematicians the mathematicians to set
     */
    public void setMathematicians(ArrayList<Mathematician> mathematicians) {
        this.mathematicians = mathematicians;
    }

    /**
     * @param item The item to add
     */
    public void addMathematician(Mathematician item){
        if(null == mathematicians){
            mathematicians = new ArrayList<Mathematician>();
        }
        mathematicians.add(item);
    }
}