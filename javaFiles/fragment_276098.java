String stat = prop.getProperty("status"); <-- you read the property here
    if(stat.equals(status.FINISHED.toString()) || stat.equals(status.ONHOLD.toString()))
    {
        updateConfigfile(username+".properties","status",status.RUNNING.toString());
        do{
            i++;
            model.addAttribute("msg","inside loop"+" "+"Counter is:"+" "+i+" "+"status is =" +prop.getProperty("status"));  <-- status contains FINISHED or ONHOLD! It is the same as using stat variable.
        }while(prop.getProperty("status").equals(status.RUNNING.toString())); <--contains FINISHED or ONHOLD! so, always return false

    }else{
        model.addAttribute("msg","Service is already running");

    }