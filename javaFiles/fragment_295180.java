package forum12338288;

import java.util.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class WorkAdapter extends XmlAdapter<WorkAdapter.AdaptedWork, Work> {

    public static class AdaptedWork {
        public List<Relation> relations = new ArrayList<Relation>();
    }

    @Override
    public AdaptedWork marshal(Work work) throws Exception {
        AdaptedWork adaptedWork = new AdaptedWork();
        for(RelationList relationList : work.relationList) {
            for(Relation relation : relationList.relation) {
                adaptedWork.relations.add(relation);
            }
        }
        return adaptedWork;
    }

    @Override
    public Work unmarshal(AdaptedWork adaptedWork) throws Exception {
        Work work = new Work();
        RelationList relationList = new RelationList();
        for(Relation relation : adaptedWork.relations) {
            relationList.relation.add(relation);
        }
        work.relationList.add(relationList);
        return work;
    }

}