@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportRequest {

  @NotNull
  private String startDate;

  @NotNull
  private String endDate;

  private Integer userId;

  private Integer type;

 }