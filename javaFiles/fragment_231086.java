public static class Process1 implements CSProcess {

    private ChannelOutputInt output;

    public Process1(ChannelOutputInt out) {
        output = out;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            System.out.println("Written...");
            output.write(5);
        }
        output.write(-1);
    }

}

public static class Process2 implements CSProcess {

    private ChannelInputInt input;

    public Process2(ChannelInputInt in) {
        input = in;
    }

    @Override
    public void run() {
        int x = 0;
        while ((x = input.read()) > 0) {
            System.out.println(x);
        }
    }

}

public static void main(String[] args) {

    One2OneChannelInt chan = Channel.one2oneInt();

    Process1 process1 = new Process1(chan.out());
    Process2 process2 = new Process2(chan.in());

    Parallel parallel = new Parallel();

    parallel.addProcess(process1);
    parallel.addProcess(process2);
    parallel.run();
}