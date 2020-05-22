FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                    .beginTransaction();
Fragment newFragment = new Fragment1();
transaction.add(R.id.content_frame, newFragment);
transaction.addToBackStack(null);
transaction.commit();