List<DD_Details> list = new ArrayList<DD_Details>();
  List<DD_Details> list1 = new ArrayList<DD_Details>();
  list.add(new DD_Details(new Date(2014, 5, 26), 3000.00));
  list.add(new DD_Details(new Date(2014, 8, 26), 6000.00));
  list.add(new DD_Details(new Date(2014, 8, 26), 2000.00));

  for (DD_Details currentEl : list) // iterate over 'list'
  {
     DD_Details existingElement = null;
     for (DD_Details el1 : list1) // find element in 'list1' with the same date
     {
        if (el1.getDdSubmissionDate().equals(currentEl.getDdSubmissionDate()))
        {
           existingElement = el1;
           break;
        }
     }
     if (existingElement == null) // if element is not found in 'list1' then add current element to list
     {
        list1.add(currentEl); // or list1.add(new DD_Details(el.getDdSubmissionDate(), el.getAmount()))
     }
     else // if element is found, then increase amount
     {
        existingElement.setAmount(existingElement.getAmount() + currentEl.getAmount());
     }
  }

  // 'list1' contains what you need