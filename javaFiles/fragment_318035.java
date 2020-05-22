private Bitmap makeTextLayer(int maxWidth, int maxHeight, ImageObject imageObject) {
        Context c = mContext;
        View v = LayoutInflater.from(c).inflate(R.layout.text_view_generator, new LinearLayout(c), false);
        RelativeLayout editTexts = (RelativeLayout) v.findViewById(R.id.editTexts);

        initView(v, maxWidth, maxHeight);

        for (int i = 0; i < imageObject.getEditTexts().size(); ++i) {
            ImageObject.TextInImage textInImage = imageObject.getEditTexts().get(i);
            //text view in relative layout - init his size, in my case it's as big as image
            CustomEditText editText = new CustomEditText(c);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
            // don't forget to add your view to layout, this view will be saved as screenshot
            editTexts.addView(editText, params);
            editText.getLayoutParams().width = maxWidth;
            editText.getLayoutParams().height = maxHeight;
            editText.loadTextParams(textInImage);
            editText.loadSizeAndRotation(textInImage);
            // this is important, without new init - position of text will be wrong
            initView(v, maxWidth, maxHeight);
            // and here i configure position
            editText.loadPosition();
        }

        Bitmap result = getViewBitmap(v, maxWidth, maxHeight);
        return result;
    }

    Bitmap getViewBitmap(View v, int maxWidth, int maxHeight) {
        //Get the dimensions of the view so we can re-layout the view at its current size
        //and create a bitmap of the same size
        int width = v.getWidth();
        int height = v.getHeight();

        int measuredWidth = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
        int measuredHeight = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);

        //Cause the view to re-layout
        v.measure(measuredWidth, measuredHeight);
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());

        //Create a bitmap backed Canvas to draw the view into
        Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);

        //Now that the view is laid out and we have a canvas, ask the view to draw itself into the canvas
        v.draw(c);

        return b;
    }

    private void initView(View view,  int maxWidth, int maxHeight){
        ViewGroup.LayoutParams vParams = view.getLayoutParams();
        //If the View hasn't been attached to a layout, or had LayoutParams set
        //return null, or handle this case however you want
        if (vParams == null) {
            return;
        }
        int wSpec = measureSpecFromDimension(vParams.width, maxWidth);
        int hSpec = measureSpecFromDimension(vParams.height, maxHeight);
        view.measure(wSpec, hSpec);
        int width = view.getMeasuredWidth();
        int height = view.getMeasuredHeight();
        //Cannot make a zero-width or zero-height bitmap
        if (width == 0 || height == 0) {
            return;
        }
        view.layout(0, 0, width, height);
    }

    private int measureSpecFromDimension(int dimension, int maxDimension) {
        switch (dimension) {
            case ViewGroup.LayoutParams.MATCH_PARENT:
                return View.MeasureSpec.makeMeasureSpec(maxDimension, View.MeasureSpec.EXACTLY);
            case ViewGroup.LayoutParams.WRAP_CONTENT:
                return View.MeasureSpec.makeMeasureSpec(maxDimension, View.MeasureSpec.AT_MOST);
            default:
                return View.MeasureSpec.makeMeasureSpec(dimension, View.MeasureSpec.EXACTLY);
        }
    }