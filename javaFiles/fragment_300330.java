@Value("${test}")
String message1;

@Override
public String check(String message) {
  if (message == null) {
    return message1;
  }
}