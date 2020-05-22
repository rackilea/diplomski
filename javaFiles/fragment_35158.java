@Entity
@Table
public class ConnectionInformation implements Serializable {

    @Column
    private String connectionType;

    @Transient  
    public ConnectionType getConnectionTypeAsEnum() {
        return connectionType == null ? null : ConnectionType.valueOf(connectionType); 
    }

    public void assertConnectionType() {
        try {
            getConnectionTypeAsEnum();
        } catch(IllegalArgumentException ex) {
            throw new IllegalArgumentException(
                String.format("Invalid `connectionType`: %s", conectionType), ex);  
        }      
    }

}