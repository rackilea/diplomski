if (Character.toLowerCase(newWord.charAt(x)) != letterInput.charAt(0))
                    {


                        guesses= guesses - 1;
                        System.out.println("Your letter was not found in spaces you provided");
                        System.out.println("Guesses Remaining: " + guesses);

                    }