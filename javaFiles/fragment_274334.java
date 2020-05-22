public class Grapher {
    public static void main(String[] args) throws Exception {
        Grapher.graph4("filename.dot", Guice.createInjector(new MyModule()));
    }
    public static void graph4(String filename, Injector inj) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintWriter out = new PrintWriter(baos);

        Injector injector = Guice.createInjector(new GraphvizModule());
        GraphvizGrapher renderer = injector.getInstance(GraphvizGrapher.class);
        renderer.setOut(out);
        renderer.setRankdir("TB");
        renderer.graph(inj);    

        out = new PrintWriter(new File(filename), "UTF-8");
        String s = baos.toString("UTF-8");
        s = fixGrapherBug(s);
        s = hideClassPaths(s);
        out.write(s);
        out.close();
    }

    public static String hideClassPaths(String s) {
        s = s.replaceAll("\\w[a-z\\d_\\.]+\\.([A-Z][A-Za-z\\d_\\$]*)", "$1");
        s = s.replaceAll("value=[\\w-]+", "random");
        return s;
    }

    public static String fixGrapherBug(String s) {
        s = s.replaceAll("style=invis", "style=solid");
        s = s.replaceAll("margin=(\\S+), ", " margin=\"$1\", ");
        return s;
    }
}