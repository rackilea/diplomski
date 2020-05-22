package hello;

import com.thoughtworks.xstream.XStream;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;

class Player {
}

class Main {
    public static void main(String[] args) throws Exception {
        CtClass player = ClassPool.getDefault().get("hello.Player");
        CtField toAdd = CtField.make("public java.lang.String nick = null;", player);
        player.addField(toAdd);

        Class patchedPlayer = player.toClass();
        Object o = patchedPlayer.newInstance();

        patchedPlayer.getField("nick").set(o, "hello, Player");

        String s = new XStream().toXML(o);
        System.out.println(s);
    }
}