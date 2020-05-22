final String regex = "/[0-9]+(?:\\.[0-9]+)+=([^,]+)";
final String string = "O=ABC Bank Plc/1.2.3.47=ABC12-PQR-121878, CN=7ltM2wQ3bqlDJdBEURGAMq, L=INDIA, C=INDIA, E=xyz@gmail.com";

final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(string);

if (matcher.find()) {
    System.out.println(matcher.group(1));
}