public class HibernatetEntityAdapter extends XmlAdapter<AbstractEntity, AbstractEntity> {

@Override
public AbstractEntity unmarshal(AbstractEntity v) throws Exception {
    return v;
}

@Override
public AbstractEntity marshal(AbstractEntity v) throws Exception {
    return HibernateUtils.unenhanceObject(v);
}

}