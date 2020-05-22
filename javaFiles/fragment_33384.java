//declare globally

    f_wworks fw;
    f_ptasks fp;
    f_qexams fq;

     @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: 
                    fw = f_wworks.newInstance();
                    return fw;
                case 1:
                    fp = f_ptasks.newInstance();
                    return fp;
                case 2:
                    fq = f_qexams.newInstance();
                    return  fq;
                default:
                    return null;
            }
        }

private void populateList()
{
//Once you created adapter
   fw.setDataToAdapter(wwAdapter); //do this to other fragments
}