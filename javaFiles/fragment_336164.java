if ((a == 0) && (b == 0) && (c == 0))
    {
        System.out.println("No solutions to quadratic formula with these inputs!");
    }
    else
    {
        double d = b * b - 4*a*c;
        double x1 = (-b - Math.sqrt(d)) / (2 * a);
        double x2 = (-b + Math.sqrt(d)) / (2 * a);
        System.out.println(x1);
        System.out.println(x2);
    }

    System.out.println("Continue? ");

    input = in.next();
}
while (input.equals("Y"));