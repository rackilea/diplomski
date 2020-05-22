import static org.junit.Assume.assumeNotNull;

// later in the code
void someMethod() {
   assumeNotNull(expectedFile, actualFile);
   // Rest of code goes here
}