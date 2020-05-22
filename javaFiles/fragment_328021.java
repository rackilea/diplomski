@Document
public class Template {

 @Id
 private UUID id = UUID.randomUUID();

 @CreatedDate
 private Date createdOn;
 @LastModifiedDate
 private Date modifiedOn;
 @CreatedBy
 private String createdBy;
 @LastModifiedBy
 private String modifiedBy;
 @Version
 private Integer version;
}