final String fileName = "test.txt";
final byte[] content = "Hallo Word".getBytes();
MockMultipartFile mockMultipartFile =
       new MockMultipartFile("content", fileName, "text/plain", content);

uploadClassifiedPicture(1, 1, "token", mockMultipartFile);