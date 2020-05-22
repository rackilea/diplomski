public class Test {

public static void main(String[] args) {
    List<Record> records = new ArrayList<Record>() {
        {
            add(new Record("M1", "", "G1", "A1"));
            add(new Record("M1", "", "G1", "A2"));

            add(new Record("M1", "G1", "G2", "A3"));
            add(new Record("M1", "G1", "G2", "A4"));
        }
    };

    MessageContainer messageContainer = new MessageContainer();
    for (Record record : records) {
        messageContainer.addOrUpdateMessage(record);
    }

}

private static class Record {

    final String messageId;
    final String parentGroupId;
    final String groupId;
    final String attributeId;

    public Record(String messageId, String parentGroupId, String groupId, String attributeId) {
        super();
        this.messageId = messageId;
        this.parentGroupId = parentGroupId;
        this.groupId = groupId;
        this.attributeId = attributeId;
    }

}

private static class MessageContainer {

    Map<String, MBean> messages = new HashMap<String, MBean>();

    public void addOrUpdateMessage(Record record) {
        MBean mBean = messages.get(record.messageId);
        if (mBean == null) {
            mBean = new MBean(record.messageId);
            messages.put(record.messageId, mBean);
        }
        mBean.addOrUpdateGroup(record);
    }
}

private static class MBean {
    private final String mes_id;
    private final Map<String, GBean> groups = new HashMap<String, GBean>();

    public MBean(String mesId) {
        super();
        mes_id = mesId;
    }

    public void addOrUpdateGroup(Record record) {
        String groupToHandle = (record.parentGroupId != "" ? record.parentGroupId : record.groupId);
        GBean gBean = groups.get(groupToHandle);
        if (gBean == null) {
            gBean = new GBean(groupToHandle);
            groups.put(groupToHandle, gBean);
        }
        gBean.addOrUpdateGroup(record);
    }
}

private static class GBean {
    private final String groupId;
    private final Map<String, ABean> attributes = new HashMap<String, ABean>();
    private final Map<String, GBean> underGroups = new HashMap<String, GBean>();

    public GBean(String groupId) {
        super();
        this.groupId = groupId;
    }

    public void addOrUpdateGroup(Record record) {
        if (groupId == record.parentGroupId) {

            GBean child = underGroups.get(record.groupId);
            if (child == null) {
                child = new GBean(record.groupId);
                underGroups.put(record.groupId, child);
            }
            child.addOrUpdateGroup(record);

        } else if (groupId == record.groupId) {
            attributes.put(record.attributeId, new ABean(record.attributeId));
        } else {
            throw new RuntimeException("Unexpected state [recordParentGroupId="+record.parentGroupId+", recordGroupId="+record.groupId+", groupId="+groupId+"]");

        }

    }

    private static class ABean {
        private final String attr_id;
        public ABean(String attrId) {
            super();
            attr_id = attrId;
        }

    }
}
}