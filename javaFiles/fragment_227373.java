int minLength = Collections.min(yourListOfString, new Comparator<String>() {
                       @Override
                       public int compare(String arg0, String arg1) {
                           return arg0.length() - arg1.length();
                       }
                 }).length();

for(String s : yourListOfString)
{
    if(s.length() == minLength)
    {
       if(!yourResultList.contains(s))
           yourResultList.add(s);
    }
}