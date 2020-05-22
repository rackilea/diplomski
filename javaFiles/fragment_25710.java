for(int i=0;i< sortedRoles_Flags.length+1-sizeOfFlags;i++)
                {
                    if(sortedRoles_Flags[i].matches("Y|y|Y\\?|\\?Y|y\\?|\\?y"))
                        {
                            System.out.println("Hotel security:"+" "+sortedRoles_Flags[i]+" HS Added: "+Query.hotelSecurity[i]);
                            finalHS += Query.hotelSecurity[i]+"+";
                            System.out.println("Hotel security:"+" "+finalHS);
                        }
                }

                //add Security Flags to Final Flags
                for(int i=(sortedRoles_Flags.length-sizeOfFlags+1);i< sortedRoles_Flags.length;i++)
                {                   
                        finalFlags += Query.securityFlags[j]+"\t\t: "+ sortedRoles_Flags[i]+" + ";


   j++;
                }