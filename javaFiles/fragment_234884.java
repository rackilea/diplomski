@JsonRootName("trailer_standard_loads")
@JsonIgnoreProperties(ignoreUnknown=true)     
  public class StandardLoad {
  @JsonProperty("trailer_load_seq")
  private Integer trailerLoadSeq;
  private String createdBy;
  private ZonedDateTime createdDt;
  private String updatedBy;
  private ZonedDateTime updatedDt;

  private Boolean dueOverrideFlag;

    @JsonProperty("due_override_flag")
    public void setDueOverrideFlag(String value)  {

     this.dueOverrideFlag = value.equalsIgnoreCase("Y) ? true : false;

      }

     public Boolean getDueOverrideFlag() {

      return this.dueOverrideFlag;

      }
  }