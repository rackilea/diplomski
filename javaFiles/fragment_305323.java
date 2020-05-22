@Service
public class OptionServiceImpl implements OptionService {

    private OptionA optionA;
    private OptionB optionB;

    @Override
    public Option findOption(boolean businessLogic) {
        if(businessLogic){
            return getOptionA();
        } else {
            return getOptionB();
        }
    }

    public OptionA getOptionA() {
        return optionA;
    }

    @Autowired
    public void setOptionA(OptionA optionA) {
        this.optionA = optionA;
    }

    public OptionB getOptionB() {
        return optionB;
    }

    @Autowired
    public void setOptionB(OptionB optionB) {
        this.optionB = optionB;
    }
}