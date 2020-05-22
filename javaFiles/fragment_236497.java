boolean activate() {
      try {
          // Do Something risky...
          return true;

      } catch(IOException e){
        return false;
      }
      catch (FileNotFoundException e){
        return false;
      }

   }