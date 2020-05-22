// import org.apache.commons.io.output.StringBuilderWriter;
// import org.apache.commons.io.input.BoundedInputStream;
// import org.apache.commons.io.IOUtils;

BoundedInputStream boundedInput = new BoundedInputStream(originalInput, <max-file-size>);
BufferedReader reader = new BufferedReader(new InputStreamReader(boundedInput), 2048);

StringBuilder output = new StringBuilder();
StringBuilderWriter writer = new StringBuilderWriter(output);

IOUtils.copy(reader, writer); // copies data from "reader" => "writer"
return output;