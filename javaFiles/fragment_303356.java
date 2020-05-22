import java.util.*;

public class Ch5Ex2 {
    public static void main(String[] args) {
        List<String> li = new ArrayList<String>();
        Print pri = new Print();
        pri.start();
        Insert in = new Insert(li, pri);
        in.start();
    }
}


class Insert extends Thread {
    Print pr;
    List<String> x;
    public Insert(List<String> x, Print p) {
        this.x = x;
        pr = p;
    }

    public synchronized void run() {
        try{
            x.add("robin");
            x.add("ravi");
            x.add("raj");
            pr.print(x);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class Print extends Thread {
    List<String> y;
    public synchronized void print(List<String> y) {
        this.y = y;
        notify();
    }

    public synchronized void run() {
        try {
            while(y == null){
                wait();
            }
            for(int i=0;i<y.size();i++) {
                System.out.println(y.get(i));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}