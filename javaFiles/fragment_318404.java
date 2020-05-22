public final class WebService {

   private static GreenAppService sInstance;

   public static GreenAppService getInstance() {
       if (sInstance == null) {
           sInstance = new Retrofit
           .Builder()
           .baseUrl(Constants.API_V1_ENDPOINT)
           .build();
       }

       return sInstance;
   }
}