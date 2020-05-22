@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierRootDto {

    // ADD NAME TO MATCH THE XML ELEMENT
    @XmlElement(name = "supplier")
    private List<SupplierDto> supplierDtos;

    public SupplierRootDto() {
    }

    public List<SupplierDto> getSupplierDtos() {
        return supplierDtos;
    }

    public void setSupplierDtos(List<SupplierDto> supplierDtos) {
        this.supplierDtos = supplierDtos;
    }
}