manager = getActivity().getSupportFragmentManager();
manager.beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                    R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(
                            R.id.content_main,
                            zapisFragment)
// and so on...