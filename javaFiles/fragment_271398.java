public class BaseEntryAdapter extends XmlAdapter<AdaptedBaseEntry, BaseEntry>
{

    @Override
    public BaseEntry unmarshal(AdaptedBaseEntry v) throws Exception
    {
        switch (v.type)
        {
        case Machine:
            return new Machine(v.name, v.description, v.code);
        case Robot:
            return new Robot(v.name, v.description, v.serial);
        default:
            return null;
        }
    }

    @Override
    public AdaptedBaseEntry marshal(BaseEntry v) throws Exception
    {
        return new AdaptedBaseEntry(v);
    }

}