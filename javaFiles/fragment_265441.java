public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
  View view = inflater.inflate(R.layout.your_fragment_layout, container, false);
  ImageView imvQrCode = (ImageView) view.findViewById(R.id.your_image_view);

  Bitmap bitmap = textToImage("your_text_info", 500, 500);
  imageView.setImageBitmap(bitmap);

  return view;
}