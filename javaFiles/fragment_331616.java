@Entity
@Indexed
public class MyEntity{
    @Id
    @Field 
    public Long id;

    @Field(bridge=@FieldBridge(impl=EnumBridge.class))
    @Enumerated(EnumType.STRING)
    public Flavour flavour;
}