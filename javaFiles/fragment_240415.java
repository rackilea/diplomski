public class StatusAdapter extends XMLAdapter<String, Status> {
    @Override
    public Status unmarshal(String status) throws Exception {

        return Status.fromValue(status.toLowerCase()); /* ensure status is not 
           blank, or you should check null before toLowerCase(). Usually, `required` is
     set in XML annotations, eg @XMLAttribute(name = "name", required = true) */
    }

    @Override
    public String marshal(Status status) throws Exception {

        return status.value();
    }
}