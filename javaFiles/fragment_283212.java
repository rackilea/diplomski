import java.io.File;
import java.io.IOException;
import java.util.*;

public class Text2ObjArray {

    public static void main(String[] args) {
        Person[] participants = loadFile(new File(args.length > 0
            ? args[0] : "Participants.txt"));
        for (Person p : participants)
            System.out.println("Participant: " + p);
    }