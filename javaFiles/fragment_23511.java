// SkipSearch method
public void skipSearch(String SSN)
{
    Node tmp = head;
    //System.out.println(tmp);

    if (tmp != null) {
        while((tmp.first != null) 
                && (tmp.first.SSN != null) 
                && (SSN.charAt(0) < tmp.first.SSN.charAt(0))
                )
        {
            tmp = tmp.first;
        }
        while((tmp.second != null) 
                && (tmp.second.SSN != null) 
                && SSN.charAt(1) < tmp.second.SSN.charAt(1))
        {
            tmp = tmp.second;
        }
        while((tmp.third != null) 
                && (tmp.third.SSN != null) 
                && SSN.charAt(2) < tmp.third.SSN.charAt(2))
        {
            tmp = tmp.third;
        }
        while((tmp.fourth != null) 
                && (tmp.fourth.SSN != null) 
                && SSN.charAt(3) < tmp.fourth.SSN.charAt(3))
        {
            tmp = tmp.fourth;
        }
        while(tmp.fourth != null)
        {
            tmp = tmp.fourth;
            if(tmp.SSN.equals(SSN))
            {
                System.out.println(tmp.toString()+"has been found.");
                endTimer();
                System.out.println("Search took: " + timeElapsed()+ " seconds");
            }
        }
    }
}