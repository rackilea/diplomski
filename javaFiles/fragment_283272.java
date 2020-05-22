@GlideModule
public class MyAppGlideModule extends AppGlideModule {

@Override
public void registerComponents(Context context, Glide glide, Registry registry) {
    // Register FirebaseImageLoader to handle StorageReference
    registry.append(StorageReference.class, InputStream.class,
            new FirebaseImageLoader.Factory());
  }
}