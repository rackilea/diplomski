class TimeRefreshRace extends JLabel implements ActionListener {

    private Timer timer;

    public void start() {
        timer = new Timer(1000, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent ae) {
        int tempoInSecondi = programma.getTempoGara() % 60;
        int minuti = programma.getTempoGara() / 60;
        if (minuti <= 0 && tempoInSecondi<=1) {
            this.setText("00:00");
            salvaDatiCorsa();
            break;
        }
        if(tempoInSecondi<=1){
            minuti--;
            tempoInSecondi=60;
        }
        --tempoInSecondi;
        this.setText(minuti+":"+ tempoInSecondi);

    }

    public void kill() {
        if (timer != null) {
            timer.stop()
        }
    }

}//fine autoclass