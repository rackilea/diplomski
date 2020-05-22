private Callable<Boolean> newUserIsAdded() {
      return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                  return userRepository.size() == 1; // The condition that must be fulfilled
            }
      };
}