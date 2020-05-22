@Override
        public int getItemViewType(int position) {
            if (...) return 1;
            else if (...) return 2;
            else if (...) return 3;
            else return 4;
        }

        @Override
        public int getViewTypeCount() {
            return 4; //total number of different type of views 
        }


        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {


            switch (getItemViewType(position)) {
                case 0:
                    if (view == null) {
                        view = mActivity.getLayoutInflater().inflate(R.layout.message_item_1, viewGroup, false);
                    }
                    break;
                case 1:
                    if (view == null) {
                        view = mActivity.getLayoutInflater().inflate(R.layout.message_item_1_media, viewGroup, false);
                    }
                    break;
                case 2:
                    if (view == null) {
                        view = mActivity.getLayoutInflater().inflate(R.layout.message_item_2, viewGroup, false);
                    }
                    break;
                case 3:
                    if (view == null) {
                        view = mActivity.getLayoutInflater().inflate(R.layout.message_item_2_media, viewGroup, false);
                    }
                    break;
            }
    }