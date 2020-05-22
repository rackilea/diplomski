package test;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {

    private static Map<Integer, String> strings = new HashMap<Integer, String>();
    private static Set<Integer> classes = new HashSet<Integer>();
    private static int indexCorrection = 0; // for correcting indexes to constant pools with long and double entries

    public static void main(String[] args) throws Exception {
        printReferencedClassesFromClass(String.class);
    }

    private static void printReferencedClassesFromClass(Class<?> c) throws IOException {
        saveReferencedClassesFromStream(c.getResourceAsStream(c.getSimpleName() + ".class"));
        printReferencedClasses();
    }

    private static void printReferencedClasses() {
        for (Integer index : classes)
            System.out.println(strings.get(index));
    }

    private static void saveReferencedClassesFromStream(InputStream stream) throws IOException {
        DataInputStream dataStream = new DataInputStream(stream);
        skipHeader(dataStream);
        saveReferencedClassesFromConstantPool(dataStream);
    }

    private static void skipHeader(DataInputStream dataInputStream) throws IOException {
        readU4(dataInputStream); // magic byte
        readU2(dataInputStream); // minor version
        readU2(dataInputStream); // major version
    }

    private static void saveReferencedClassesFromConstantPool(DataInputStream stream) throws IOException {
        int poolSize = readU2(stream);
        for (int n = 1; n < poolSize - indexCorrection; n++)
            savePoolEntryIfIsClassReference(n, stream);
    }

    private static void savePoolEntryIfIsClassReference(int index, DataInputStream stream) throws IOException {
        int tag = readU1(stream);
        switch (tag) {
        case 1: // Utf8
            saveStringFromUtf8Entry(index, stream);
            break;
        case 7: // Class
            saveClassEntry(stream);
            break;
        case 8: // String
        case 16: // MethodType
            readU2(stream);
            break;
        case 3: // Integer
        case 4: // Float
            readU4(stream);
            break;
        case 5: // Long
        case 6: // Double
            readU4(stream);
            readU4(stream);
            indexCorrection++;
            break;
        case 9: // Fieldref
        case 10: // Methodref
        case 11: // InterfaceMethodref
        case 12: // NameAndType
        case 18: // InvokeDynmaic
            readU2(stream);
            readU2(stream);
            break;
        case 15: // MethodHandle
            readU1(stream);
            readU2(stream);
            break;
        }
    }

    private static void saveClassEntry(DataInputStream stream) throws IOException {
        classes.add(readU2(stream));
    }

    private static void saveStringFromUtf8Entry(int index, DataInputStream stream) throws IOException {
        strings.put(index + indexCorrection, readString(stream));
    }

    private static String readString(DataInputStream stream) throws IOException {
        return stream.readUTF();
    }

    private static int readU1(DataInputStream stream) throws IOException {
        return stream.readUnsignedByte();
    }

    private static int readU2(DataInputStream stream) throws IOException {
        return stream.readUnsignedShort();
    }

    private static int readU4(DataInputStream stream) throws IOException {
        return stream.readInt();
    }

}