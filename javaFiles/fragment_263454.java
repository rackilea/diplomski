//other classes:
    private View getView(){
        if(viewAvailable) {
           return view;
        } else {
            return EmptyView.emptyView;
        }  
    }

    public void showView(){
        getView().show();
    }