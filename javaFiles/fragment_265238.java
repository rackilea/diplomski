catch (SQLException e) {
      String message = e.getMessage();
      String[] errorsArray = AuthErrorsConst.ERROR;
      for (int i = 0; i < errorsArray.length; i++) {
          if (message.contains(errorsArray[i])) {
              System.out.println("throwing LoginException")// NEW
              throw new LoginException(); // LOOK AT THIS
          }
      }
      throw e;
}