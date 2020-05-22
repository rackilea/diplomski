private void openArticleWith(String title, String content){
            Fragment fragment = new ArticleFragment.newInstance(title, content);
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.bottomtop, R.anim.topbottom,R.anim.popbottomtop,R.anim.poptopbottom);
            fragmentTransaction.replace(R.id.content_main, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
}