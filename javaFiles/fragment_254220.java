OnPropertyChangedCallbackStub loadingCallback = new OnPropertyChangedCallbackStub();
    viewModel.loading.addOnPropertyChangedCallback(loadingCallback);

    // invoke the code-under-test which, internally, invokes ...
    // loading.set(true);
    // loading.set(false);

    assertTrue(2, loadingCallback.recordedInvocations().size());
    assertTrue(loadingCallback.recordedInvocations().contains(true));
    assertTrue(loadingCallback.recordedInvocations().contains(false));