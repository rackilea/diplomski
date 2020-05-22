TakesScreenshot ts = (TakesScreenshot)driver;
byte[] image = ts.getScreenshotAs(OutputType.BYTES);

try {
  File screenshot = new File("/some/path/myscreenshot.png");
  FileOutputStream fos = new FileOutputStream(screenshot);
  fos.write(image);
  fos.close();
} catch (IOException ex) {
  fail("Failed to write screenshot");
}