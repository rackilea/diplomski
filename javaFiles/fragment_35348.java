package bcm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.InstructionPrinter;

public class Person {

    String name;
    String surname;
    int age;

    boolean candrink = false;

    public Person(String name, String surname, int age) {
        super();
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void doSomething() {
        if (this.age > 18) {
            candrink = true;
        }
    }

    public static void main(String[] args) throws IOException,
            CannotCompileException {
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass cc = pool.get("bcm.Person");
            CtMethod m = cc.getDeclaredMethod("doSomething", null);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            InstructionPrinter i = new InstructionPrinter(ps);
            i.print(m);
            String content = baos.toString();

            for (String line : content.split("\\r?\\n")) {
                if (line.contains("getfield")) {
                    System.out.println(line.replaceAll("getfield ", ""));
                }
            }

        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

}