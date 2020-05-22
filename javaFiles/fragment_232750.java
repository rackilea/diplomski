package forum10972195;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CustomEnumAdapter extends XmlAdapter<EnumBean, Day> {

    @Override
    public EnumBean marshal(Day v) throws Exception {
        EnumBean mine = new EnumBean(v.ordinal(), v.name());
        return mine;
    }

    @Override
    public Day unmarshal(EnumBean v) throws Exception {
        Day day = new Day(v.getOrdinal(),v.getName());
        return day;
    }

}