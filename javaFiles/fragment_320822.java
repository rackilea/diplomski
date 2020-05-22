import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.util.Map;
import java.util.Set;

class TestProtobufEnum {
    public static void main(String[] args) {
        PaxTypeEnum.EnumProto.PaxType CHILD =.
            PaxTypeEnum.EnumProto.PaxType.CHILD;

        System.out.println("get fields dynamically for PaxType.CHILD");
        Set<Map.Entry<Descriptors.FieldDescriptor, Object>> allFields =.
            CHILD.getValueDescriptor().getOptions().getAllFields().entrySet();
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : allFields){
            System.out.printf("field: descriptor: %-14s  value: %s%n",
                    entry.getKey().getName(),
                    entry.getValue()
            );
        }

        System.out.println("get fields statically");
        PaxTypeEnum.EnumProto.PaxType[] paxTypes =.
                PaxTypeEnum.EnumProto.PaxType.values();
        for (PaxTypeEnum.EnumProto.PaxType value : paxTypes) {
            DescriptorProtos.EnumValueOptions options =.
                    value.getValueDescriptor().getOptions();
            System.out.printf("PaxType: %-6s  name: %s  singleCharCode: %s%n",
                    value.toString(),
                    options.getExtension(PaxTypeEnum.EnumProto.name),
                    options.getExtension(PaxTypeEnum.EnumProto.singleCharCode)
            );
        }

    }
}