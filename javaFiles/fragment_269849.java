@Service
public class RuntimeObjectFactoryImpl implements RuntimeObjectFactory {
    private final CustomObjectTypeA oA;
    private final CustomObjectTypeB oB;

    @Autowired
    public RuntimeObjectFactoryImpl(final CustomObjectTypeA oA, final CustomObjectTypeB oB) {
        this.oA = oA;
        this.oB = oB;
    }

    @Override
    public RuntimeObject get(CustomObjectTypeC oC) {
        return new RuntimeObject(oA, oB, oC);
    }
}