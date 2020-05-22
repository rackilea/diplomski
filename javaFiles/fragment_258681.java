public class SimiliarPhotos extends AppCompatActivity implements IResult, SimiliarPlantsAdapter.OnItemClickListener {

     @Override
        public void onTitleClicked(int position, String title, View clickedView) {
           //Handle your title click here
        }

      @Override
        public void onImageClicked(int position, View clickedView) {
            //Handle your image click here
        }

 public void initializeAdapter(){
        Log.d("plants",String.valueOf(plants.size()));
        adapter = new SimiliarPlantsAdapter(plants,SimiliarPhotos.this, SimilarPhotos.this);
        rv.setAdapter(adapter);
 }