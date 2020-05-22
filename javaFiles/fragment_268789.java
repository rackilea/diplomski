@Mocked FileReader fileReader;
@Mocked BufferedReader bufferedReader;
FileReader capturedReader;

@Test
public void mockIOClasses() throws Exception {
    new NonStrictExpectations() {{
        new FileReader("filename");
        result = new Delegate() {
            void captureIt(Invocation inv) {
                capturedReader = inv.getInvokedInstance();
            }
        };
        times = 1;

        new BufferedReader(with(new Delegate<Reader>() {
            void check(Reader in) { assertSame(capturedReader, in); }
        }));
        times = 1;
    }};

    new BufferedReader(new FileReader("filename"));
}

@Test
public void mockIOClasses2() throws Exception
{
    new NonStrictExpectations() {{
        new FileReader("filename");
        result = new Delegate() {
            void captureIt(Invocation inv) {
                capturedReader = inv.getInvokedInstance();
            }
        };
    }};

    new BufferedReader(new FileReader("filename"));

    new Verifications() {{
        FileReader r;
        new BufferedReader(r = withCapture());
        assertSame(capturedReader, r);
    }};
}