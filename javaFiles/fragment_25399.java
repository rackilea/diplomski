import java.util.*;
enum Field {
    field1((byte) 0xc0) {
        int filter_(byte mask) { // you may want this one to be different
            return mask & this.mask;
        }
    },
    field2((byte) 0x20), field3((byte) 0x10), field4((byte) 0x08);
    Field(byte mask) {
        this.mask = mask;
    }
    int filter_(byte mask) {
        return mask & this.mask;
    }
    static EnumSet<Field> filter(byte mask) {
        final EnumSet<Field> fields = EnumSet.noneOf(Field.class);
        for (Field field : values())
            if (field.filter_(mask) != 0) fields.add(field);
        return fields;
    }
    final byte mask;
}
public class Main {
    public static void main(String[] args) {
        for(Field field:Field.values()) {
            System.out.println(Field.filter(field.mask));
        }
    }
}