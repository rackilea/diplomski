public abstract class AbstractTwoWayConverter<S, T> implements GenericConverter {

    private Class<S> classOfS;
    private Class<T> classOfT;

    protected AbstractTwoWayConverter() {
        Type typeA = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type typeB = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.classOfS = (Class) typeA;
        this.classOfT = (Class) typeB;
    }

    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<ConvertiblePair>();
        convertiblePairs.add(new ConvertiblePair(classOfS, classOfT));
        convertiblePairs.add(new ConvertiblePair(classOfT, classOfS));
        return convertiblePairs;
    }

    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (classOfS.equals(sourceType.getType())) {
            return this.convert((S) source);
        } else {
            return this.convertBack((T) source);
        }
    }

    protected abstract T convert(S source);

    protected abstract S convertBack(T target);

}

/** 
 * converter to convert between a userId and user.
 * this class can be registered like so: 
 * conversionService.addConverter(new UserIdConverter (userDao));
 */ 
public class UserIdConverter extends AbstractTwoWayConverter<String, User> {

    private final UserDao userDao;

    @Autowired
    public UserIdConverter(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    protected User convert(String userId) {
        return userDao.load(userId);
    }

    @Override
    protected String convertBack(User target) {
        return target.getUserId();
    }
}