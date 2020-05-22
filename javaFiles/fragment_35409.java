final int[] critical_requests = new int[]{ 0 };
final Outputstream out = ...;
ActionListener task_performer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            critical_requests[0] = critical_requests[0] + 1;
            try {
                out.write("Critical Section request:\t" + (critical_requests[0]) + "\n");
                ((Timer)evt.getSource()).setDelay( 10 + (rand.nextInt() % 10) );
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(-1);
            }
        }
};
Timer the_one_and_only_timer = new Timer( wait_delay, task_performer );