switch(tab.getPosition()){
                case 0 :
                   // fragmentManager.beginTransaction().hide(historyFragment);
                    fragmentManager.beginTransaction().replace(R.id.frm_content, homeFragment)
                            .commit();
                    break;
               case 1:
                    fragmentManager.beginTransaction().replace(R.id.frm_content, historyFragment)
                            .commit();
                    break;
                case 2 :


            }