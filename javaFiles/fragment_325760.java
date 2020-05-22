public class CSP {
    private String aField;
    private int[] array;
    private int[][] twoDArr;
    private List<ALContent> list; //here ALContent also needs to override clone properly

    @Override
    public Object clone() {
        CSP clone = new CSP();
        clone.aField = this.aField;
        clone.array = new int[this.array.length];
        System.arraycopy(this.array, 0, clone.array, 0, this.array.length);

        clone.list = new ArrayList<ALContent>();
        for(ALContent content : this.list) {
            clone.list.add(content.clone()); //make sure you add the clone of the content
        }

        clone.twoDArr = new int[this.twoDArr.length][];
        for(int i=0; i<this.twoDArr.length; i++) {
            clone.twoDArr[i] = new int[this.twoDArr[i].length];
            System.arraycopy(this.twoDArr[i], 0, clone.twoDArr[i], 0, this.twoDArr[i].length);
        }

        return clone;
    }
}