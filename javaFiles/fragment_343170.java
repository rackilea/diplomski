package ejbtest.action;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ejbtest.utility.Utility;

@Stateless
public class Trigger1 {

    @EJB
    private Utility utility;

    public Integer getTriggerCount() {
        return utility.getCount();
    }
}