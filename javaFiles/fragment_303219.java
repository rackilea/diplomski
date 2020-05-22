int x = 0;
do
{
    System.out.print("Enter next number:");
    user_input = user.nextLine();
    x = Integer.valueOf(user_input);

    if (x != -1)
    {
        holdv = user_input;
        holdvx += holdv + ",";
        ascend += holdv + " ";
    }

} while (x != -1);

System.out.println("THANK YOU FOR ENTERING= " + holdvx);