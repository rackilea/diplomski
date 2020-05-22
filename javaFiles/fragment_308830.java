@Override
public void run() {
    int max = Html.totale;
    for(int i=1;i<=max;i++){
        try {
            SwingUtiliites.invokeLater(new Runnable(){
               public void run(){
                   jTable1.setValueAt(Integer.valueOf(i),row,2);
               }
            }
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
    }
}