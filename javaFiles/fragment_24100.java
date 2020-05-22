import javax.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;

@XmlType(propOrder = { "startDateTime","endDateTime","durationMinutes","remainingMinutes","percentComplete","nodesDiscovered","nodesTried",
                        "totalNodes", "discoveryCompleted","canceledFlag" })
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DiscoveryStatus implements Serializable {
    private Number discoveryCompleted=0;
    private Date  startDateTime = new Date();
    private Date  endDateTime  = new Date();

    @XmlTransient
    private Number startMS =20;

    @XmlTransient
    private Number currMS =20;

    private Number durationMinutes =AppSettings.DiscoveryNodeMulticastDurationMins;
    private Number remainingMinutes =20;

    private Boolean canceledFlag=false;
    private Number percentComplete =0;
    private Number nodesDiscovered =0;
    private Number nodesTried =0;
    private Number totalNodes =0;

    public DiscoveryStatus(){
        totalNodes =1;
    }

}