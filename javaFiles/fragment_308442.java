public class OverlapDecoration extends RecyclerView.ItemDecoration {

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent,
                                   RecyclerView.State state) {
            final int itemPosition = parent.getChildAdapterPosition(view);
            if (itemPosition == 0) {
                return;
            }
            outRect.set(0, 0, 0, -150);//<-- bottom
        }

    }

recyclerView.addItemDecoration(new OverlappDecoration());
recyclerview.setLayoutManager(new LinearLayoutManager(context));