import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Retrieve response from the REST API    
String json_response = receiveResponse();

// Define the regex pattern
String pattern = "\"([^\"]+)" *: *null";

// Create a Pattern object
Pattern r = Pattern.compile(pattern);

// Now create matcher object.
Matcher m = r.matcher(json_response);
if (m.find( )) {
   // Print the entire match
   System.out.println("Found value: " + m.group(0) );   // > "end_time": null
   // Print capture group 1
   System.out.println("Found null for: " + m.group(1) ); // > end_time
} else {
  System.out.println("NO MATCH");
}