@Component
public class MyComponentConfig1 extends MyComponent {

    public MyComponentConfig1(@Value("myconfig.config1") String config) {
          super(config);
    }

}