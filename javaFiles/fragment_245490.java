finally {
          try {
            connection.close();
         }
          catch (IOException e){
              e.printStackTrace();
          }
        }