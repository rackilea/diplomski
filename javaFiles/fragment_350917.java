Thread t;
public myclass()//your constructor
{
t=new Thread(this);
}

    open.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            calls();
        }
    });


    private void calls() {
        t.start();
    }

    @Override
    public void run() {
        reads();
    }

    public void reads() {
        ....
        ....
        counter++;
t.interrupt();// The Thread should stop here right>

    }