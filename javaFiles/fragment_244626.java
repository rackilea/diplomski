public GenericModel {

   @ApiModelProperty(value = "ID")
   private int id;

   @ApiModelProperty(value = "Code")
   private String code;

   @ApiModelProperty(value = "Parent Id")
   private int parentId;

   @ApiModelProperty(value = "Children")
   private List<GenericModel> children = new ArrayList<>();

   ...
}