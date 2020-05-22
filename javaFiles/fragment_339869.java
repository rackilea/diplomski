else if( (r1==1 && r2==1) && (k>=2) /* Check to see if there are 2+ killers; Must be 2+ killers for them to meet */ )
{
    //Remove 2 killers
    k-=2;
    //Display meeting and result
    System.out.println("K&K: P=" + p + " K=" + k);
}