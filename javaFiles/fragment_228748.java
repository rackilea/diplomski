public Fragment getItem(int position) {

       tempPosition=position+1;
      if (dayspassed>= tempPosition) 
          {
          if (isRanking) 
          {
          return new RankingsFragment();
          }else
          {
          return new ScheduleFragment();
          }
       } else 
       {
        return new NAFragment();
       }
     }
   }