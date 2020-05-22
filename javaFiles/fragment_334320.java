Practice2 newFragment = new Practice2();

                bundle.putString("id", "Information");
                newFragment.setArguments(bundle);

                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager
                        .beginTransaction();

                transaction.replace(R.id.llhome, newFragment);

                // Commit the transaction
                transaction.commit();