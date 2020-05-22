public static  boolean isPalindrome (int number)
        {
            int undoReverse = 0;
            int inputNumber = number;

            while(number > 0)  
            {
                undoReverse = undoReverse * 10 + number % 10;
                number /= 10; 
            }

            if(inputNumber == undoReverse)
                   return true;

            else 
                return false;
            }
}