public static boolean isFragmentShowing(Activity activity, String tag) throws Exception {

//validate request 
if(activity == null) {
    // throw exception or return value 
}   
if (tag == null && tag.equals("")){
    // throw exception or return value 
}
// rest of the part
FragmentManager fragmentManager = FragmentUtils.getFragmentManagerInstance(activity);
Fragment fragment = fragmentManager.findFragmentByTag(tag);
return (fragment != null && fragment.isVisible())? true : false;
}