package forum7278406;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TargetAdapter extends XmlAdapter<Long, Target> {

    @Override
    public Long marshal(Target target) throws Exception {
        return target.getId();
    }

    @Override
    public Target unmarshal(Long id) throws Exception {
        Target target = new Target();
        target.setId(id);
        return target;
    }

}