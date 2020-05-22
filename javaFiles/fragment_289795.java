public class ImageFragment extends Fragment{
View view;
ImageView ivImage;
Bundle bundle;
String imageUrl;
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_image, null);
    ivImage = (ImageView)view.findViewById(R.id.ivImageAlbum);
    bundle = getArguments();
    if(bundle != null){
        imageUrl = bundle.getString("image_url");
        try{
            ImageLoader.getInstance().displayImage(imageUrl, ivImage, ImageLoadOption.options);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }


    return view;
}