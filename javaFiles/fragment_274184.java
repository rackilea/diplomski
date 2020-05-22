if ((typeOfCarCost.equals("Electric") || typeOfCarCost.equals("electric")) && ((SolarPanelCost.equals("No") || SolarPanelCost.equals("no")))
                                    {
                                        total = basicPrice + ElectricModel;
                                        System.out.println("Basic Price:" + basicPrice);
                                        System.out.println("Electric Model:" + ElectricModel);
                                        System.out.println("Total:" + total);

                                    }
else if ((typeOfCarCost.equals("Electric") || typeOfCarCost.equals("electric")) && (SolarPanelCost.equals("Yes") || SolarPanelCost.equals("yes")))
                                    {
                                        total = basicPrice + ElectricModel + SolarPanel;
                                        System.out.println("Basic Price:" + basicPrice);
                                        System.out.println("Electric Model:" + ElectricModel);
                                        System.out.println("Solar Panel:" + SolarPanel);
                                        System.out.println("Total:" + total);
                                    }