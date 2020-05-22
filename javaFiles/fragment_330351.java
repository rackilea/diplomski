public ViewModel(final Repository repository) {
        //observe userId and trigger isVerifiedUser when userId value is changed
        stateLiveData = Transformations.map(userId, new Function<>() {
            @Override
            public RepoMoviesResult apply(Integer userId) {
                return repository.isVerifiedUser(userId);
            }
        });
    }