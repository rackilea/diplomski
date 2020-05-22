public static FragmentFactory getFragment(int position){
    switch(position){
    case 1:
         return Factory1;
    case 2:
         return Factory2;
    ...
    default:
         throw new IllegalArgument("No Fragment defined for that position");
}