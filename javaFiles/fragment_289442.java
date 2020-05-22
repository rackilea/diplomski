public class ClientDTO {
    //client fields
    private String nomResponsable = "";
    ....
    //subclass 1 fields.... initialize to empty
    //subclass 2 fields .... initialize to empty

    public ClientDTO (Client client) {
        // set fields for client entity
    }

    public ClientDTO (Societe societe) {
        this (societe);
        // set societe fields.
    }
    // other constructors.
}