public class ProgramLogic {
    public void perform(OurBean bean) {
        if (bean != null && bean.getWaybillTransactionId() != null) {
            // Do some action
        }
    }
}

public class OurBean {
    public String getWaybillTransactionId() {
        return waybill == null ? null : waybill.getTransactionGuid();
    }
}

public class Waybill {
    public String getTransactionGuid() {
        return transaction == null ? null : transaction.getGuid();
    }
}