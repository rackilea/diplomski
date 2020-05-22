case SimpleGestureFilter.SWIPE_DOWN : if(navY > 0)
                                            navY--;
                                        prefEditor.putInt("navYPref", navY);
                                        prefEditor.apply();
                                        break;
   case SimpleGestureFilter.SWIPE_UP : if(navY < 10)
                                           navY++;
                                       prefEditor.putInt("navYPref", navY);
                                       prefEditor.apply();
                                       break;