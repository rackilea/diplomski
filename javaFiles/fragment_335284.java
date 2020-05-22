try {
      userTransaction.begin();

      //operation to insert information in table USER

      //operation to insert information in table ADDRESS

      //operation to insert information in table TELEPHONE

      userTransaction.commit();
   } catch (Exception e) {
      userTransaction.rollback();
   }