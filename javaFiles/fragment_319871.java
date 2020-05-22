public class PeopleQuickstart {

    ...

    public static void main(String [] args)  throws IOException {

        People service = getPeopleService();

        // Request 120 connections.
        ListConnectionsResponse response = service.people().connections()
                .list("people/me")
                .setPageSize(120)
                // specify fields to be returned
                .setRequestMaskIncludeField("person.names,person.emailAddresses,person.phoneNumbers")
                .execute();

        // Display information about a person.
        List<Person> connections = response.getConnections();
        if (connections != null && connections.size() > 0) {
            for (Person person: connections){
                getPersonInfo(person);
            }
        } else {
            System.out.println("No connections found.");
        }   
    }
}