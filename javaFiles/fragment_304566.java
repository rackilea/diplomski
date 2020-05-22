@XmlType(name = "Errors")
@XmlAccessorType(XmlAccessType.FIELD)
public class BtnErrorListType {
    @XmlElement(name = "Error")
    private ArrayList<BtnErrorType> btnError;

    ...
    public ArrayList<BtnErrorType> getBtnError() {
        if (btnError == null)
            btnError = new ArrayList<BtnErrorType>();
        return btnError;
    }
    ...
}