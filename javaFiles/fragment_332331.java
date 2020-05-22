public boolean isValidImei(String s){
        long n = Long.parseLong(s);
        int l = s.length();

        if(l!=15) // If length is not 15 then IMEI is Invalid
            return false;
        else
        {
            int d = 0, sum = 0;
            for(int i=15; i>=1; i--)
            {
                d = (int)(n%10);

                if(i%2 == 0)
                {
                    d = 2*d; // Doubling every alternate digit
                }

                sum = sum + sumDig(d); // Finding sum of the digits

                n = n/10;
            }

            System.out.println("Output : Sum = "+sum);

            if(sum%10==0 && sum!=0)
                return true;
            else
                return false;
        }
}