@Module
public class SampleMainPresenterModule {

   SampleMainView view;
   SampleMainInteractor sampleMainInteractor;

   @Provides
   @Singleton
   SampleMainView providesSampleMainView(){
     return view; //null pointer here
   }

   @Provides
   @Singleton
   SampleMainInteractor providesSampleInteractor(){
     return sampleMainInteractor; //null pointer here
   }
}