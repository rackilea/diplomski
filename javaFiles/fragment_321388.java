public class CustomComparator implements Comparator<MyObject> {
    @Override
    public int compare(MyObject o1, MyObject o2) {
        String[] env =new String[]{"Demo","Test","Developement","Production"};
        int env1=-1,env2=-1;
        for(int i =0; i < env.length; i++)
        {
            if(env1<0 && o1.getCompanyName().contains(env[i]))
            {
                env1=i;
            }

            if(env2<0 && o2.getCompanyName().contains(env[i]))
            {
                env2=i;
            }
        }
        return (env1 < env2) ? 1 :(env1 == env2)? 0: -1;
    }
}