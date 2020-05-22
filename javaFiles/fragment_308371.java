temp = in.readLine();
while (temp != null)
{
    System.out.println("String from txt file =" + temp);

if(searchString.equals(temp))
{
        System.out.println("word is match");
        in.close();
        return;
    }
    else
    {
        System.out.println("word is not match");
    }

    temp = in.readLine();
}