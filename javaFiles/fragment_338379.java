SearchTerm term = null;

Calendar cal = null;
cal = Calendar.getInstance();
Date minDate = new Date(cal.getTimeInMillis());   //get today date

cal.add(Calendar.DAY_OF_MONTH, 1);                //add 1 day
Date maxDate = new Date(cal.getTimeInMillis());   //get tomorrow date
ReceivedDateTerm minDateTerm = new ReceivedDateTerm(ComparisonTerm.GE, minDate);
ReceivedDateTerm maxDateTerm = new ReceivedDateTerm(ComparisonTerm.LE, maxDate);

term = new AndTerm(term, minDateTerm);            //concat the search terms
term = new AndTerm(term, maxDateTerm);

Message messages[] = folderInbox.search(term);    //search on the imap server