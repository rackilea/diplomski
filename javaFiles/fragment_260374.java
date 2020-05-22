public class PersonDto {
    private Long id;
    private String name;
    private String street;

    public PersonDto() {
    }

    public PersonDto(Long id, String name, String street) {
        this.id = id;
        this.name = name;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public static class NameColumn extends DtoTableModel.ColumnProvider<PersonDto, String> {

        public NameColumn() {
            super("Name", String.class);
        }

        @Override
        public String getValue(PersonDto dto) {
            return dto.getName();
        }

        @Override
        public void setValue(PersonDto dto, Object value) {
            dto.setName((String) value);
        }
    }

    public static class StreetColumn extends DtoTableModel.ColumnProvider<PersonDto, String> {

        public StreetColumn() {
            super("Street", String.class);
        }

        @Override
        public String getValue(PersonDto dto) {
            return dto.getStreet();
        }

        @Override
        public void setValue(PersonDto dto, Object value) {
            dto.setStreet((String) value);
        }
    }
}