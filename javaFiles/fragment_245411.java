import java.nio.file.*;

Path pdfFilePath = Paths.get("/file/path/your_file.pdf");

// Read file to byte array
byte[] pdfByteArray = Files.readAllBytes(pdfFilePath );

// Write byte array to file 
Files.write(pdfFilePath , pdfByteArray);