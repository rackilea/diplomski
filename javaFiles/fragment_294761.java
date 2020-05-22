DecimalFormat formatter = new DecimalFormat("###,###");

// Now wrap each and every desiredmethod output like formatter.format(methodOutput())     
System.out.println("Name of dam:\t\t" + getName() +
                 "\nYear opened:\t\t" + getYear() +
                 "\nAge [yrs}:\t\t" + getAge() +
                 "\nDate as of:\t\t" + getDate() +
                 "\nStorage:\t\t" + getStorage() + 
                 "\nCapacity:\t\t" + getCapacity() + 
                 "\nInflow:\t\t\t" + formatter.format(getInflow()) + 
                 "\nOutflow:\t\t" + formatter.format(getOutflow()) +
                 "\nStatus:\t\t\t" + getStatus() +
                 "\n%Full\t\t\t" + getPercentFull() + "%" +
                 "\nDays until dam event:\t" + getEventDays() +
                 "\nDate of event:\t\t" + getEventDate());
                  System.out.println();