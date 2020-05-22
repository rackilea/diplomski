String fragMainGroups = "mainGroups";
                            String Groups = "Groups";

                            Fragment fragment = (Fragment) getFragmentManager().findFragmentByTag(fragMainGroups);                                              


                            if (fragment != null) // could be null if not instantiated yet
                            {
                                if (fragment.getView() != null) {
                                    // Pop the backstack on the ChildManager if there is any. If not, close this activity as normal.
                                    if (!fragment.getFragmentManager().popBackStackImmediate()) {
                                        fragment.getFragmentManager().popBackStack();
                                        //getActivity().finish();
                                    }
                                }
                            }