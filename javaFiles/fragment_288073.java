public class ApiRequestModel {

    private int adq;


    private String cnpj;


    private int blockcode;

    public ApiRequestModel(int adq, String cnpj, int blockcode) {
        this.adq = adq;
        this.cnpj = cnpj;
        this.blockcode = blockcode;
    }

    public int getAdq() {
        return adq;
    }

    public void setAdq(int adq) {
        this.adq = adq;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getBlockcode() {
        return blockcode;
    }

    public void setBlockcode(int blockcode) {
        this.blockcode = blockcode;
    }
}

public class ApiResponseModel {


    private int adq;


    private String cnpj;


    private int blockcode;

    public ApiResponseModel( @JsonProperty("adq") int adq,  @JsonProperty("cnpj") String cnpj, @JsonProperty("blockcode") int blockcode) {
        this.adq = adq;
        this.cnpj = cnpj;
        this.blockcode = blockcode;
    }

    public int getAdq() {
        return adq;
    }

    public void setAdq(int adq) {
        this.adq = adq;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getBlockcode() {
        return blockcode;
    }

    public void setBlockcode(int blockcode) {
        this.blockcode = blockcode;
    }
}