@JsonIgnoreProperties(ignoreUnknown=true)
 @JacksonXmlRootElement(localName = "results")
 public class Results {


@JacksonXmlProperty(localName = "result")
@JacksonXmlElementWrapper(useWrapping = false)
public Result [] result;


public Results() {
        }


public Result[] getResult() {
    return result;
}


public void setResult(Result[] result) {
    this.result = result;
}


@Override
public String toString() {
    return "Results [result=" + Arrays.toString(result) + "]";
}