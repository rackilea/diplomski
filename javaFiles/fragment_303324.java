public class FoxTable {

private boolean teclado = false;

public FoxTable (){
    Accion();
}

public boolean si(){
    if (teclado) {
        teclado = false;
        return true;
    }
    return true;
}

private void Accion() {

    CaretListener as = new CaretListener() {
        public void caretUpdate(CaretEvent e) {
            teclado = true;
            System.out.println(e.getDot()+" Dot");
            System.out.println(e.getMark()+" Mark");
        }
    };

    KeyAdapter focus = new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case 10:
                    e.getComponent().transferFocus();
                    si();
                    break;
            }
        }
    };
}