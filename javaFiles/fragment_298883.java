public interface TextService {

    public void save();

    public List<SingleText> test();

}


@Service
public class TextServiceImpl implements TextService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save() {
        SingleText text = new SingleText();
        text.setTestText("S.Grey");

        Session session = sessionFactory.getCurrentSession();
        session.save(text);
    }

    @Override
    @Transactional
    public List<SingleText> test() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(SingleText.class).list();
    }

}