final HashSet<String> VALUES = new HashSet<String>(Arrays.asList(new String[] {"OK (0.07, 0.05, 0.01)",
                "OK (0.07, 0.05, 0.02)",
                "OK (0.07, 0.05, 0.03)",
                "no (0.07, 0.05, 0.04)"}));
        String s="OK";

        @Test 
        public void teste(){

            for (String a : VALUES) {
                if(a.contains(s)){
                    System.out.println("Ok yes!" + true);
                }else{
                    System.out.println("Don't exist!" + false);
                }
            }

        }