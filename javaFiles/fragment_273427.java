if (!hasBothForks){
        print("is hungry");
        print( "checks if forks are free");            
      }

      if(right.isFree() == true && left.isFree() == true && hasBothForks == false)
      {
          print("is grabbing forks");
          right.takeFork();
          left.takeFork();
          hasBothForks = true;
      } // end if
      else if(hasBothForks == true)
      {
          print("is eating");
          Thread.sleep(2000);
          print("is putting down left fork");
          left.returnFork();
          print("is putting down right fork");
          right.returnFork();
          print("is finished eating");
          hasBothForks = false;
      } // end if
      else if((right.isFree() == false || left.isFree() == false) && hasBothForks == false)
          {
              print("is thinking");
              Thread.sleep(2000);
          } // end if