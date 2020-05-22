import java.io.IOException;
import java.io.PrintStream;
public class LineEndingAwarePrintStream extends PrintStream {
    private boolean didEndLine;

    public LineEndingAwarePrintStream(PrintStream inner) {
        super(inner);
        didEndLine = false;
    }   

    @Override
    public void print(char arg0) {
        didEndLine = arg0 == '\n';
        super.print(arg0);
    }
    @Override
    public void print(char[] arg0) {
        if(arg0.length > 0) {
            didEndLine = arg0[arg0.length-1] == '\n';
        }
        super.print(arg0);
    }
    @Override
    public void print(String arg0) {
        if(arg0.length() > 0) {
            didEndLine = arg0.charAt(arg0.length()-1) == '\n';
        }
        super.print(arg0);
    }

    @Override
    public void println() {
        super.println();
        didEndLine = true;
    }
    @Override
    public void println(boolean arg0) {
        super.println(arg0);
        didEndLine = true;
    }
    @Override
    public void println(char arg0) {
        super.println(arg0);
        didEndLine = true;
    }
    @Override
    public void println(char[] arg0) {
        super.println(arg0);
        didEndLine = true;
    }
    @Override
    public void println(double arg0) {
        super.println(arg0);
        didEndLine = true;
    }
    @Override
    public void println(float arg0) {
        super.println(arg0);
        didEndLine = true;
    }
    @Override
    public void println(int arg0) {
        super.println(arg0);
        didEndLine = true;
    }
    @Override
    public void println(long arg0) {
        super.println(arg0);
        didEndLine = true;
    }
    @Override
    public void println(Object arg0) {
        super.println(arg0);
        didEndLine = true;
    }
    @Override
    public void println(String arg0) {
        super.println(arg0);
        didEndLine = true;
    }

    @Override
    public void print(boolean b) {
        super.print(b);
        didEndLine = false;
    }
    @Override
    public void print(double d) {
        super.print(d);
        didEndLine = false;
    }
    @Override
    public void print(float f) {
        super.print(f);
        didEndLine = false;
    }
    @Override
    public void print(int i) {
        super.print(i);
        didEndLine = false;
    }
    @Override
    public void print(long l) {
        super.print(l);
        didEndLine = false;
    }
    @Override
    public void print(Object obj) {
        super.print(obj);
        didEndLine = false;
    }
    public void assertNewLine() {
        if(!didEndLine) {
            this.println();
        }
    }

    public void printOnNewLine(Object arg) {
        this.assertNewLine();
        this.println(arg);
    }

    public static void main(String[] arg) {
        LineEndingAwarePrintStream out = new LineEndingAwarePrintStream(System.out);
        out.println("New line");
        out.printOnNewLine("Not two newlines");
        out.print("New line");
        out.println("No new line");
        out.print("New line");
        out.printOnNewLine("New line");
        out.append('3');
        out.printOnNewLine("New line");
        out.append("Test");
        out.append('\n');
        out.printOnNewLine("Not two newlines");
        out.append("Test\n");
        out.printOnNewLine("Not two newlines");
        out.close();
    }
}