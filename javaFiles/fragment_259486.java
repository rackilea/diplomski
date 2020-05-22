class Bear implements TotemPole {

      int bearCount;
      TotemPole totem;
      public Bear(TotemPole totem){
          bearCount = 3;
          this.totem = totem;
      }


      public int power() {
          int result = 0;
          if(totem == null) {
              result = 5;
          } else {
             result = totem.power() + 5;
          }
        return result;
      }


      public Bear() {
        bearCount = 3;
      }

      public int height(){
        return bearCount + 5;
      }

      public boolean chiefPole(int bearCount){
        if(this.bearCount >= bearCount){
          return true;
        } else {
          return false;
        }
      }
    }