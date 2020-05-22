public class MainS extends JFrame{
...
    public MainS(){
        AddDialogS adddialog=new AddDialogS(MainS.this);
        adddialog.setVisible(true);

        BookInformation B_info=adddialog.getBookInfos();
        ...