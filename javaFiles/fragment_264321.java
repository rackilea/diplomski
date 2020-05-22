public class UploadServiceFactory {
  public UploadService getService(String type) {
    if ("Motor".equals(type)) {
      return new MotorUploadService();
    }
    else if ("Heal".equals(type)) {
      return new HealUploadService();
    }
  }
}