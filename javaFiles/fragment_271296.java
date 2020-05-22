public class PlacementPost extends CommonPost {
            Context context=PlacementPost.this;
            Class aclass=Placements.class;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                on_create(aclass);
            }
        }