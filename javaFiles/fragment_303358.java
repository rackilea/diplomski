@Module
public class SampleMainPresenterModule {

   SampleMainView view;
   SampleMainInteractor sampleMainInteractor;

   SampleMainPresenterModule(SampleMainView view, SampleMainInteractor interactor) {
       this.view = view;
       this.interactor = interactor;
   }

   @Provides
   @Singleton
   SampleMainView providesSampleMainView(){
     return view; 
   }

   @Provides
   @Singleton
   SampleMainInteractor providesSampleInteractor(){
     return sampleMainInteractor;
   }
}