// Map the result to desired format
// Using RxJava operators to perform checks
// If user is null or not
public void checkUserExists(String userId) {
    dao.loadUserDetails(userId)
        .map(new Function<UserLoginDetails, Boolean>() {
            @Override
            public Boolean apply(UserLoginDetails userLoginDetails) throws Exception {
                if(userLoginDetails == null){
                    return false;
                } else {
                    return true;
                }
            }
        })
        .subscribe(getObserver());
}