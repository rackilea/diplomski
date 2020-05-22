public class App {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        SO.Response response = SO.Response.newBuilder()
            .addCandidates(SO.Candidate.newBuilder().build())
            .addCandidates(SO.Candidate.newBuilder().build())
            .addCandidates(SO.Candidate.newBuilder().build())
            .putErrors("error1", SO.ErrorMessage.newBuilder().setMessage("error1").setType(SO.ErrorType.ERROR).build())
            .putErrors("error2", SO.ErrorMessage.newBuilder().setMessage("error2").setType(SO.ErrorType.WARNING).build())
            .build();

        System.out.println(JsonFormat.printer().print(response));
    }
}