public static int get(Context c) {
            if (mYearCategory == null) {
              synchronized(YearClass.class) { 
                if (mYearCategory == null) {
                  mYearCategory = categorizeByYear(c);
                } 
              } 
            } 
            return mYearCategory;
          }