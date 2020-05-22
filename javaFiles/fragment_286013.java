Collections.sort(friends,
                 new Comparator<FriendProfile>()
                 {
                     public int compare(FriendProfile o1,
                                        FriendProfile o2)
                     {
                         if (o1.getUserPosition() ==
                                 o2.getUserPosition())
                         {
                             return 0;
                         }
                         else if (o1.getUserPosition() <
                                      o2.getUserPosition())
                         {
                             return -1;
                         }
                         return 1;
                     }
                 });