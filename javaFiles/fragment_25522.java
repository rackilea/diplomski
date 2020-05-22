System.out.println("before deleting: " +tempAns + "\n");
        double num2 = Double.parseDouble(tempAns.remove(tempAns.size()-1));
        double num1 = Double.parseDouble(tempAns.remove(tempAns.size()-1));
        double ans = num1 + num2;
        String stringAns = Double.toString(ans);

        System.out.println("before adding: " +tempAns);
        tempAns.add(stringAns);
        System.out.println(num1 + " + " +num2+ " = " +ans);
        System.out.println("after deleting: " +tempAns + "\n");