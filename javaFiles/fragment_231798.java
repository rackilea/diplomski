public interface BaseOjectInterface {
        @JsonIgnore
        String getId();
    }

 public static class Pojo1 extends BaseObject implements BaseOjectInterface  {
        private String subPojo1;
        private String subPojo2;