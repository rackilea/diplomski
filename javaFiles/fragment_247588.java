static final int HEADER = 1;
     static final int FOOTER = 2;
     static final int LEFT_SECTION = 4;
     static final int RIGHT_SECTION = 8;

     int flags = 0;

     boolean isEnabledFooter() {
         return (flags & FOOTER) != 0;
     }

     void enableFooter() {
         flags |= FOOTER;
     }

     void disableFooter() {
         flags &= ~FOOTER;
     }