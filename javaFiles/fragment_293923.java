public  void loadSelection(int i){
        drawerList.setItemChecked(i,true);


        switch (i) {
            case 0:
                FragmentHome  homeFragment    = new FragmentHome();

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.FragmentHolder, homeFragment)

                        .commit();
                break;


            case 1:

                AddEntry addEntry    = new AddEntry();

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.FragmentHolder,addEntry)

                        .commit();

                break;




            case 2:
                BmiFrag myBiFragment = new BmiFrag();

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.replace(R.id.FragmentHolder, myBiFragment)


                        .commit();
                break;


            case 3:

                AboutApp aboutApp    = new AboutApp();

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.FragmentHolder, aboutApp)

                        .commit();


                break;



            case 4 :

                AddEntry addEntry    = new AddEntry();

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.FragmentHolder,addEntry)

                        .commit();


                break;

        }

    }