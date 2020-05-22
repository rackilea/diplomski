public class myEditText extends EditText{
  public myEditText(Context context){
    super(context);
  }

  public myEditText(Context context, AttributeSet attrs){
    super(context, attrs);
  }

  public myEditText(Context context, AttributeSet attrs, int defStyle){
    super(context, attrs, defStyle);
  }

  public setEditTextEmpty(){
    setText("");
  }