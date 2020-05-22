@NamedNativeQuery(
        name = "getLoginDet", 
        query = "{call GET_LOGIN_DET(?,:userId)}", 
        resultClass = Login.class
        hints = {@QueryHint(name = "org.hibernate.callable", value = "true")})
@Entity
@Table(name = "T_LOGIN_DET")
public class Login {