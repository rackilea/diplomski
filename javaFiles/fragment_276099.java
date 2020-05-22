String stat = prop.getProperty("status");
            if(stat.equals(status.FINISHED.toString()) || stat.equals(status.ONHOLD.toString()))
            {
                updateConfigfile(username+".properties","status",status.RUNNING.toString());
                prop.setProperty("status",status.RUNNING.toString());
                i++;
                model.addAttribute("msg","inside loop"+" "+"Counter is:"+" "+i+" "+"status is =" +prop.getProperty("status"));
            }else{
                model.addAttribute("msg","Service is already running");

            }