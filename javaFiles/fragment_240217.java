public class SampleController extends Controller {
    @Inject Sample sample;

    public Promise<Result> apiCall() {
        sample.callApi();
        return promise(() -> ok());
    }
}