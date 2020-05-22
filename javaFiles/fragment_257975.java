@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoreType", propOrder = {
    "mataOrMatb"
})
public class StoreType {

@XmlElements({
    @XmlElement(name = "mata", type = MaterialA.class),
    @XmlElement(name = "matb", type = MaterialB.class)
})
protected List<Material> mataOrMatb;

public List<Material> getMataOrMatb() {
    if (mataOrMatb == null) {
        mataOrMatb = new ArrayList<Material>();
    }
    return this.mataOrMatb;
}

}