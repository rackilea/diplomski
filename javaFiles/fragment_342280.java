try {
  repository.startTransaction();
  inject1.throwException();
  repository.deletedata()
  inject2.throwException();
  repository.commitTransaction();
}