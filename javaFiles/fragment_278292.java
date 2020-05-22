import gov.bop.rabid.datahandler.bean.InmateDataBean;

import java.util.EventObject;

public class InmatePhotoEventObject extends EventObject {

    private static final long serialVersionUID = 1L;

    protected InmateDataBean inmate;

    public InmatePhotoEventObject(Object source) {
        super(source);
    }

    public InmateDataBean getInmate() {
        return inmate;
    }

    public void setInmate(InmateDataBean inmate) {
        this.inmate = inmate;
    }

}