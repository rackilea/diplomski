System.out.print("The palindromic perfect squares are as follows:\n");

        for (int i = start + 1; i < finish; i++) {
            if (isPalindrome(i) && isPerfectSquare(i) ) {
                System.out.println(i);
            }

        }