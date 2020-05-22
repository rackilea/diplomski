@Override
public void onFragmentInteraction(String taskId, String taskName, String assigneeRef) { 
    CommentsFragment commentsFragment = CommentsFragment.newInstance(taskId, taskName);
    mSectionsPagerAdapter.fragmentList.remove(2);
    mSectionsPagerAdapter.fragmentList.add(commentsFragment);
    mSectionsPagerAdapter.notifyDataSetChanged();
    mViewPager.setCurrentItem(2);
}