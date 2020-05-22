TestActivity activity = getActivity();
TestFragment fragment = spy(new TestFragment());
getInstrumentation().callActivityOnStart(activity);
activity.getSupportFragmentManager().beginTransaction()
        .add(android.R.id.content, fragment, "FragmentTag")
        .commit();
getInstrumentation().callActivityOnResume(activity);
activity.onPostResume();

assertTrue(fragment.isResumed());
InOrder inOrder = inOrder(fragment);
inOrder.verify(fragment).onCreate(any(Bundle.class));
inOrder.verify(fragment).onViewCreated(any(View.class), any(Bundle.class));
inOrder.verify(fragment).onActivityCreated(any(Bundle.class));
inOrder.verify(fragment).onStart();
inOrder.verify(fragment).onResume();