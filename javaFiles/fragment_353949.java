FragmentManager fm = getSupportFragmentManager();
android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
CommentsFragment commentsFragment = CommentsFragment.newInstance(mTaskId, mTaskName);
ft.replace(R.id.container, commentsFragment);
ft.addToBackStack(null);
ft.commit();