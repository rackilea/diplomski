@Entity
@IdClass(ChildKey.class)
@Table(name = "child")
@FilterDef(name = "usernameFilter", parameters = {
        @ParamDef( name = "username", type="string")
})
public class Child { ... }