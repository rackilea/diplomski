Gson gson = new Gson();
To myTo=new To();
myTo.setNames(...);
myTo.setCallerIds(...);
myTO.setCaptions(...);
Example exm=new Example();
exm.setTo(myTo);
System.out.println(gson.toJson(exm));