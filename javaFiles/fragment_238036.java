@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionRep {
    String errorMessage;
    String errorType;
    List<String> stackTrace;
    private ExceptionRep cause;
}