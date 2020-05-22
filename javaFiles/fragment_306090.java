public class Chrono1 {
    private static int sec;
    private JTextField chrono;
    private Timer timer1; // ***** added ***

    public Chrono1(JTextField chrono){
        this.chrono = chrono;
    }

    public void Editchrono(String txt){
        int delais=1000;
        ActionListener tache_timer;
        tache_timer = new ActionListener(){
            public void actionPerformed(ActionEvent e){

                // .... etc.....

            }
        };

        if(txt.equals("START")) {

            // **** note changes? ****
            // final Timer timer1= new Timer(delais,tache_timer);  // ** no **
            timer1= new Timer(delais,tache_timer);  // ** yes! **
            timer1.start();
        }else if(txt.equals("STOP")){
            if (timer1 != null && timer1.isRunning()) {
                timer1.stop();
            }
        //sec = 0;
        }
    }
}