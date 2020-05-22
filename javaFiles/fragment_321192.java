System.out.println(System.getProperty("java.version"));
URL testURL = new URL("test", null, 0, "/", new URLStreamHandler() {
    protected URLConnection openConnection(URL u) throws IOException {
        System.out.println("creating connection to "+u);
        return new URLConnection(u) {
            InputStream is;
            public void connect(){}
            @Override
            public InputStream getInputStream() throws IOException {
                System.out.println("getInputStream() for "+u);
                if(is==null) is=new InputStream() {
                    boolean open=true;
                    @Override
                    public void close() throws IOException {
                        if(!open) return;
                        System.out.println("One InputStream for "+u+" closed");
                        open=false;
                    }
                    public int read() { return -1; }
                };
                else System.out.println("COULD be shared");
                return is;
            }
        };
    }
});
System.out.println("\n  trying new ClassLoader");
try(URLClassLoader newlClassLoader=new URLClassLoader(new URL[]{ testURL });
    InputStream is=newlClassLoader.getResourceAsStream("foo")) {}

System.out.println("\n  trying System ClassLoader");
try {
    Method m=URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
    m.setAccessible(true);
    m.invoke(ClassLoader.getSystemClassLoader(), testURL);
} catch(Exception ex) { ex.printStackTrace(); }
try(InputStream is=ClassLoader.getSystemResourceAsStream("foo")) {}

System.out.println("\n  trying bootstrap ClassLoader");
try {
    Method m=ClassLoader.class.getDeclaredMethod("getBootstrapClassPath");
    m.setAccessible(true);
    Object bootstrap = m.invoke(null);
    m=bootstrap.getClass().getDeclaredMethod("addURL", URL.class);
    m.setAccessible(true);
    m.invoke(bootstrap, testURL);
} catch(Exception ex) { ex.printStackTrace(); }

try(InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("foo")) {}