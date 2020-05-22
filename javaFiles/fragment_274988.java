import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsTest {

    public static final class Bean1 {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static final class Bean2 {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {
        final Bean1 bean1 = new Bean1();
        final Bean2 bean2 = new Bean2();

        bean1.setName("");
        BeanUtils.copyProperties(bean2, bean1);
        System.out.println("'" + bean2.getName() + "'"); // prints ''

        bean1.setName(null);
        BeanUtils.copyProperties(bean2, bean1);
        System.out.println("'" + bean2.getName() + "'"); // prints 'null'
    }
}