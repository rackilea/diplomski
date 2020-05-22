int myInt = stdin.nextInt();

if (myInt >= 0) {
 if (myInt % 2 == 0)
                sumP += myInt;
            else
                sumO += myInt;
        }
        System.out.println(sumP + " " + sumO);
        stdin.close();

    }
}