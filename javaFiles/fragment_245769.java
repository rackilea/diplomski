class CustomViewBinder extends SimplerAdapter.ViewBinder
{
            @Override
    public boolean setViewValue(View view, Object data,
            String textRepresentation) {
        int id=view.getId();
            String country=(String)data; 
                switch(id)
                {
                  case R.id.country:
                            if(country.equals("us")
                                setYourImage();
                   .....

            }
        }
}