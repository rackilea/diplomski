private View getReferenceForView(View view, int resId)
{
     if(view instanceof TextView)
         view = view.findViewById(resId);

     else if(view instanceof EditText)

     // and so on..

     return view;
  }