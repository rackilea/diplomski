public class Model{
    private String[] lines = new string[0];

    public Model( string[] lines ) {
        this.lines = lines;
    }

    public void myMethod(){
        int len = 2;
        if (lines != null) {
            len = len + lines.length;
        }
        String[] newLines = new String[len];
        for (i = 0, i < lines.length, i++) {
            newLines[i] = lines[i];
        }
    }
}