import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Parent parent = new Parent();
        parent.setParentName("Parent");
        parent.setChildren(Set.of(
                new Child(1, "A"),
                new Child(2, "B"),
                new Child(3, "C")
        ));

        ModelMapper mapper = new ModelMapper();

        Converter<Set<Child>, int[]> childSetToIntArrayConverter =
                ctx -> ctx.getSource()
                        .stream()
                        .mapToInt(Child::getId)
                        .toArray();

        mapper.createTypeMap(Parent.class, ParentDto.class)
                .addMappings(map -> map
                        .using(childSetToIntArrayConverter)
                        .map(
                                Parent::getChildren,
                                ParentDto::setChildren
                        )
                );

        ParentDto dto = mapper.map(parent, ParentDto.class);

        System.out.println(parent);
        System.out.println(dto);
    }

    @Data
    @AllArgsConstructor
    public static class Child {
        private int id;
        private String childName;
    }

    @Data
    public static class Parent {
        private Set<Child> children;
        private String parentName;
    }

    @Data
    public static class ParentDto {
        private int[] children;
        private String parentName;
    }
}