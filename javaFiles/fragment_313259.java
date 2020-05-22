@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NodeEntity
public class FieldsFrom {
   @Id
   @GeneratedValue
   private Long id;

   private String name;


   @Relationship(type= "USED_BY", direction = Relationship.INCOMING)
   private Set<FieldsTo> fieldsTo;

}