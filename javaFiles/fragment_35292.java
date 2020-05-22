@SpringView(name = UserFormView.NAME)
public class UserFormView extends VerticalLayout implements View {

    private MyService myService;

    @Autowired
    public UserFormView(MyService myService) {
        this.myService = myService;
    }

}