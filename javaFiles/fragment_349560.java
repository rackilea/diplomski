public int getItemViewType(int position) {
        if (products.size()==0){
            return 0;
        }else if (viewFormat== Constants.listV){
            return Constants.listV;
        }else if (viewFormat==Constants.gridV){
            return Constants.gridV;
        }
        return super.getItemViewType(position);
    }