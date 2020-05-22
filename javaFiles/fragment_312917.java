do
{
    try {
        System.out.print("Enter your ID#: ");
        custid = Integer.parseInt(input.readLine());
        System.out.print("Enter your Account Number#: ");
        custacctnum = Integer.parseInt(input.readLine());
    //validate the choice
        for(int i=0; i<people.length; i++)  
        {   if ((people[i].custid == custid) &&
                    (people[i].custacctnum == custacctnum))
            {   match = true;
            System.out.println("Welcome "  +people[i].firstname
                    + " to JJ Dealership!");
            for(int p=0; p<cluster.length; p++)
                System.out.println("" + (p+1) + ": " +cluster[p].year+","
                        + cluster[p].make+ "," +cluster[p].model);

            System.out.println(people[i].firstname
                     + ", what color car would you like?");
                break;
            }
        }
    } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
    }
} while (!(match));