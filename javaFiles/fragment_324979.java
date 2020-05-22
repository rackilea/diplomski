public void callMandarNuvem(){
Runnable r = new Runnable() {
    public void run() {
        Metodos.mandarNuvem(TelaCadastroRestaurante.this,rest);
    }
};