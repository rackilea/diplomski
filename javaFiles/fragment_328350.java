StringBuffer data = new StringBuffer();

                        StringBuffer variable1 = new StringBuffer();
                        if(checkboxname1.isChecked()){
                            variable1.append("<FL%20val=\"CRM%20Field%20Name%201\">CRM%20Field%20Value%201</FL>"); //Make sure to add %20 between ALL spaces, that threw me off for awhile.
                        }
                        StringBuffer variable2= new StringBuffer();
                        if(checkboxname2.isChecked()){
                            variable2.append("<FL%20val=\"CRM%20Field%20Name%202\">CRM%20Field%20Value%202</FL>");
                        }

                        data.append(variable1.toString() + variable2.toString());



                        HttpAgent.post("https://crm.zoho.com/crm/private/xml/Potentials/updateRecords?authtoken=myauthtoken&scope=crmapi&id=" + PotentialID + "&xmlData=<Potentials><row%20no=\"1\">" + data + "</row></Potentials>")


                                .go(new SuccessCallback() {
                                    @Override
                                    protected void onDone(boolean success) {

                                    }
                                });