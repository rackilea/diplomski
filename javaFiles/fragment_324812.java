public MyClass(Context context, AttributeSet attrs, int defStyle) {
      super(context, attrs, defStyle);
      // your code here
    }

    public MyClass(Context context, AttributeSet attrs) {
       // Assuming 0 is the default value of defStyle, else pass the default value
       this(context, attrs, 0);
    }

    public MyClass(Context context) {
        // Assuming null is the default value for attrs
        this(context, null);
    }