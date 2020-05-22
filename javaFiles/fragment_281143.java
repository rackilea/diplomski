@Override
 public Fragment getItem(int position) {
     switch (position) {
         case 0:
             return getFragment1Instance();
         case 1:
             return getFragment2Instance();
         // etc
     }
 }