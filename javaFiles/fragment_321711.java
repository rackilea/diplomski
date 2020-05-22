/**
 * Will work long as there are no two contacts with same first name. In that case
 * you'll need more data to find a unique contact.
 */
private void deleteByFirstName(String firstName) {
  for (Iterator<Data> iterator = contact.iterator(); iterator.hasNext();) {
    Data temp = iterator.next();

    // Add null checks for proper error handling.

    if (temp.getFirstName().equalsIgnoreCase(firstName)) {
      iterator.remove();
      return;
    }
  }

  System.out.println("No contact with first name " + firstName + " was found.");
}