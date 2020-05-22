PdfReader.unethicalreading = true;
PdfReader reader = new PdfReader(inputStream, "abc123".getBytes());

Field encryptedField = PdfReader.class.getDeclaredField("encrypted");
encryptedField.setAccessible(true);
encryptedField.set(reader, false);

PdfStamper stamper = new PdfStamper(reader, outputStream);
stamper.close();
reader.close();