public ActionWidget(Context context, AttributeSet attributeSet, int defStyle){
    super(context, attributeSet); 

    inflate(context, R.layout.action, this);

    TypedArray attributes = context.obtainStyledAttributes(attributeSet,
            R.styleable.ActionWidget);

    CharSequence attrValue = attributes
            .getString(R.styleable.ActionWidget_label);
    if (attrValue != null)
        setLabel(attrValue);

    attributes.recycle();
}