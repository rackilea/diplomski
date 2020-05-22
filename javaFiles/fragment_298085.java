public class ChatFragment extends Fragment {
private RecyclerView chatRecylerview;
View view;
ChatUserlistAdapter userlistAdapter;
LinearLayoutManager manager;
ArrayList<HashMap<String, String>> userDetail = new ArrayList<>();
HashMap<String, String> data;

@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_chat, container, false);

    btnCapture =(Button)view.findViewById(R.id.btnTakePicture);
    imgCapture = (ImageView)view.findViewById(R.id.capturedImage);
    btnCapture.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cInt,Image_Capture_Code);
        }
    });
    return view;
}


@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == Image_Capture_Code) {
        if (resultCode == RESULT_OK) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            imgCapture.setImageBitmap(bp);
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
        }
    }
}