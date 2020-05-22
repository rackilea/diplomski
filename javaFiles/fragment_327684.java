TriggerWithParameters1 twp = sm.setTriggerParameters(Trigger.D, java.util.Map.class);
sm.configure(State.D).permit(Trigger.A, State.A)
                     .onEntryFrom( twp, new Action1<Map>(){ 
                                            public void doIt(Map m) {
                                               System.out.println(m.toString());
                                            }
                                        }, Map.class);
Map data = new HashMap();
data.put("a", "1");
sm.fire(twp, data);