@Override
        public View getView()  {
            if(isLoading == true) {
                return textView;
            } else {
                return view;
                invalidate();        
    }
}