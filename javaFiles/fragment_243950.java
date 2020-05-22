public interface ProfileService {

  /* ... */
}

public interface AccountService {

  /* ... */
}

ProfileService profileService = mRestAdapter.create(ProfileService.class);
AccountService accountService = mRestAdapter.create(AccountService.class);