@MappedSuperclass
@EntityListeners( { ValidatorListener.class })
@Validators({Type.PERSIST, Type.UPDATE})
public abstract class MyEntity extends BaseEntity implements Serializable, Validateable {
    // other stuff
    @Validators(Type.PERSIST)
    @Embedded
    public Address getAddress() {
        return address;
    }
}