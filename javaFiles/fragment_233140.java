// Decyzja o kolejnych działaniach
            String dec = null;
            input.nextLine();
            do
            {
                System.out.println("Want make another eqation? [Y/N]: ");

                dec = input.nextLine();

                if(dec.equalsIgnoreCase("Y")) {
                    decision = true;
                    repeat = false;
                }
                else if(dec.equalsIgnoreCase("n")){
                    decision = false;
                    repeat = false;
                } else
                    repeat = true;
            } while(repeat);