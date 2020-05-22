package forum7278406;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TargetAdapter extends XmlAdapter<Long, Target> {

    EntityManager entityManager;

    public TargetAdapter() {
    }

    public TargetAdapter(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Long marshal(Target target) throws Exception {
        return target.getId();
    }

    @Override
    public Target unmarshal(Long id) throws Exception {
        Target target = null;
        if(null != entityManager) {
            target = entityManager.find(Target.class, id);
        }
        if(null == target) {
            target = new Target();
            target.setId(id);
        }
        return target;
    }

}