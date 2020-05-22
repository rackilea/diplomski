public class FoxTable {

    private boolean TECLADO=false;

    public FoxTable(){
        Accion();
    }

    private void Accion() {
        ExtendedCaretListener as = new ExtendedCaretListener();
        KeyAdapter focus = new ExtendedKeyAdapter(as);
    }

    public class ExtendedCaretListener implements CaretListener {
        public void caretUpdate(CaretEvent e) {
            TECLADO=true;
            System.out.println(e.getDot()+" Dot");
            System.out.println(e.getMark()+" Mark");
        }

        public boolean si(){
            if(TECLADO){
                TECLADO=false;
                return true;
            }
            return true;
        }
    }

    public class ExtendedKeyAdapter implements KeyAdapter {

        ExtendedCaretListener as = null;

        public ExtendedKeyAdapter(ExtendedCaretListener as) {
            this.as = as;
        }

        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case 10:
                    e.getComponent().transferFocus();
                    as.si();
                    break;
            }
        }
    }
}