public void back()
    {
     if ( arrList.size() > 1 )
      {
       arrList.remove(arrList.size() - 1);
       View v = arrList.get(arrList.size() - 1);

       Activity_name object = ((Activity_name)v.getContext());
       object.onResume();
       setContentView(v);
      }
     else {
      this.finish();
     }
    }