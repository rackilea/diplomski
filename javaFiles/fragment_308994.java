public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {


        Context ctx;
        //this is your images

        List<Bitmap> myImages;

        Adapter(Context context, List<Bitmap> images) {

            this.ctx = context;
            this.myImages = images;
        }


        @Override
        public Adapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = getLayoutInflater().inflate(R.layout.inflation, parent, false);

            return new myViewHolder(view);
        }

        @Override
        public void onBindViewHolder(Adapter.myViewHolder holder, int position) {

                holder.image.setImageBitmap(myImages.get(position));
        }

        @Override
        public int getItemCount() {
            return myImages.size();
        }

        class myViewHolder extends RecyclerView.ViewHolder {

            ImageView image;



            public myViewHolder(View itemView) {
                super(itemView);

                image = itemView.findViewById(R.id.image);
            }


        }


    }