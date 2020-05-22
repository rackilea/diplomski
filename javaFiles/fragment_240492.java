Queue q = new LinkedList();
q.add("two");
String n = (String)q.poll();
while(n!=null)
{
    switch (n)
    {
        case "zero":
        {
            System.out.println("zero");
            q.add("one");
            break;
        }
        case "one":
        {
            System.out.println("one");
            q.add("three");
            q.add("two");
            break;
        }
        case "two":
        {
            System.out.println("two");
            if (12>3)
            {
                q.add("four");

            }

             q.add("three");
             break;
        }
        case "three":
        {
            System.out.println("three");
            q.add("four");
            break;
        }
        case "four":
        {
            System.out.println("four");
            break;
        }
    }
    n=(String) q.poll();
}