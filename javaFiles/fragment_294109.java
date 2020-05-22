public class DaemonTest {

@Test
public void testExecute(final ConfigHelper ch, final DaemonHelper dh) {

new NonStrictExpectations(d) {
    @Mocked({"log"}
    Daemon d;
    @Mocked({"()"})
    DaemonHelper dh;
    {

    }
};


final Config c = new Config(ch);
final Daemon d = new Daemon(c, dh);
d.execute();

new Verifications() {{
    d.log("Starting");
    d.log("Ending");
}};
}
}