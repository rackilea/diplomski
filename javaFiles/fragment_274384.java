public class Pojo {

    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;

    public Pojo(PojoBuilder pojoBuilder) {
        this.field1 = pojoBuilder.field1;
        this.field2 = pojoBuilder.field2;
        this.field3 = pojoBuilder.field3;
        this.field4 = pojoBuilder.field4;
        this.field5 = pojoBuilder.field5;
    }

    public static class PojoBuilder {
        String field1;
        String field2;
        String field3;
        String field4;
        String field5;

        public PojoBuilder field1(String field1) {
            this.field1 = field1;
            return this;
        }

        public PojoBuilder field2(String field2) {
            this.field2 = field2;
            return this;
        }
        public PojoBuilder field3(String field3) {
            this.field3 = field3;
            return this;
        }
        public PojoBuilder field4(String field4) {
            this.field4 = field4;
            return this;
        }
        public PojoBuilder field5(String field5) {
            this.field5 = field5;
            return this;
        }

        public Pojo build() {
            return new Pojo(this);
        }

    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    public String getField4() {
        return field4;
    }

    public String getField5() {
        return field5;
    }


}