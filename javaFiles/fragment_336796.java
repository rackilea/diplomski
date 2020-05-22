package test;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class TestMain {

    public static void main(String[] args) {
        Kryo kryo = new Kryo();
        kryo.register(ArrayList.class);
        kryo.register(Modifier.class);

        ByteArrayOutputStream b = new ByteArrayOutputStream();

        Modifier modifier = new Modifier();
        modifier.type = "Yo swa!";
        modifier.amount = 10;

        Output output = new Output(b);
        kryo.writeClassAndObject(output, modifier);
        output.flush();
        output.close();

        System.out.println("Kryo size: " + output.toBytes().length);

        Input input = new Input(output.getBuffer());

        Modifier r = (Modifier) kryo.readClassAndObject(input);

        System.out.println(r.type);
    }

    static class Modifier {
        String type;
        int amount;
    }
}