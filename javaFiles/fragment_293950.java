public class ButtonIndexPair{
    private JButton button;
    private int indexRow;
    private int indexColumn;
    public ButtonIndexPair(JButton button,int indexRow, int indexColumn){
        this.button = button;
        this.indexRow = indexRow;
        this.indexColumn = indexColumn;
    }
    public int getRow(){
        return indexRow;
    }
    public int getColumn(){
        return indexColumn;
    }
    public JButton getButton(){
        return button;
    }
}