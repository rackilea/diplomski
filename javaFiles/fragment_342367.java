import java.io.*;

public class SplitOutputStream extends OutputStream{

    public static void main(String[] args) throws Throwable{
        SplitOutputStream split=new SplitOutputStream(
            new FileOutputStream("c:\\text.txt"),
            System.out
        );
        PrintStream splitPs=new PrintStream(split);
        splitPs.println("some text");
        splitPs.flush();
        splitPs.close();

        //or (not both)
        PrintWriter splitPw=new PrintWriter(split);
        splitPw.println("some text");
        splitPw.flush();
        splitPw.close();
    }


    OutputStream o1;
    OutputStream o2;
    public SplitOutputStream(OutputStream o1,OutputStream o2){
        this.o1=o1;
        this.o2=o2;
    }
    @Override public void write(int b) throws IOException{
        o1.write(b);
        o2.write(b);
    }
    @Override public void write(byte[] b,int off,int len) throws IOException{
        o1.write(b,off,len);
        o2.write(b,off,len);
    }
    @Override public void flush() throws IOException{
        o1.flush();
        o2.flush();
    }
    @Override public void close() throws IOException{
        o1.close();
        o2.close();
    }
}