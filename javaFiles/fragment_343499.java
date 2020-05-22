KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            DroolsIntroduction droolsIntroduction = new DroolsIntroduction("Drools");            
            kSession.insert(droolsIntroduction);
            kSession.insert(new DroolsIntroduction("All"));
            kSession.insert(new DroolsIntroduction("Specific"));
            kSession.fireAllRules();
           /* try {
                String string1 = "11:06:13";
                Date time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(time1);

                String string2 = "10:49:00";
                Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(time2);
                calendar2.add(Calendar.DATE, 1);

                String someRandomTime = "01:00:00";
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                String currenttime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                Date d = new SimpleDateFormat("HH:mm:ss").parse(currenttime);
                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTime(d);
                calendar3.add(Calendar.DATE, 1);

                Date x = calendar3.getTime();
                if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
                    //checkes whether the current time is between 14:49:00 and 20:11:13.
                    System.out.println("checkes whether the current time is between 14:49:00 and 20:11:13");
                    System.out.println(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String ccurrenttime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            System.out.println(ccurrenttime);
            isBetweenValidTime("09:33:00","09:38:00",ccurrenttime);*/


            kSession.setGlobal("topicLevel", "Beginner");
            kSession.insert(new DroolsIntroduction("All"));
            kSession.fireAllRules();