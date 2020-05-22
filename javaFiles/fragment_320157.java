for (int i = 0; i < linkedAccount.size(); i++) {
     if (linkedAccount.get(i).getStudentID() == accountNumber) {
         obj1 = linkedAccount.remove(i);
         break;
     }
}