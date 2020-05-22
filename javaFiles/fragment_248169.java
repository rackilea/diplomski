package tl.tree.functions;

import tl.TLValue;
import tl.tree.TLNode;

import java.io.PrintStream;
import java.util.Scanner;

public class InputNode implements TLNode {

    private String prompt;
    private PrintStream out;

    public InputNode(String p) {
        this(p, System.out);
    }

    public InputNode(String p, PrintStream o) {
        prompt = (p == null) ? "" : p;
        out = o;
    }

    @Override
    public TLValue evaluate() {
        out.println(prompt);
        Scanner keyboard = new Scanner(System.in);

        if(keyboard.hasNextDouble()) 
            return new TLValue(Double.valueOf(keyboard.nextDouble()));
        else if(keyboard.hasNextInt()) 
            return new TLValue(Integer.valueOf(keyboard.nextInt()));
        else if(keyboard.hasNextBoolean()) 
            return new TLValue(Boolean.valueOf(keyboard.nextBoolean()));
        else 
            return new TLValue(keyboard.nextLine().trim()); // else it's a plain string
    }
}