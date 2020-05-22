@Override
public void onClick(View v) {
  try {
    PostRequest("api endpoint");
   } catch (IOException e){
        e.printStackTrace();
    }
}