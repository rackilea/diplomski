public static void main(String[] args) {

        String postalCodeString = "4124-4125, 4133,4211,4270,4272,4275,4280,4285,4287,4307-4499,4510,4512,4515-4519,4522-4899";

        int userInput = Integer.parseInt("4308");

        String [] postalArray = postalCodeString .split(",");

        for (String post : postalArray )
        {

            if(h.contains("-"))
            {
                String [] range = post.trim().split("-"); 
                int low = Integer.parseInt(range[0]);
                int high = Integer.parseInt(range[1]);

                if(userInput<=high && userInput>=low)
                    System.out.println("Found in range "+h);
            }
            else
            {
                int pcode = Integer.parseInt(post.trim());

                if(userInput==pcode)
                    System.out.println("Found in postal code "+pcode);
            }
        }


    }