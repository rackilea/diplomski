if(isAdded())
{
            .......... your code ..............
            // Get the ImageLoader through your singleton class.
            mImageLoader = VolleySingleton.getInstance(getActivity()).getImageLoader();
                .......... your code ..............
}