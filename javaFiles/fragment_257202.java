public class file {

// Get all persons in file
public  List<Customers> getAllPersons(String fileLocation) {
        List<Customers> localPersons = new ArrayList<>();

    try {
        File f = new File(fileLocation);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                localPersons.add((Customers) ois.readObject());
            }
        } catch (EOFException e) {

        }
    } catch (IOException iOException) {
    } catch (ClassNotFoundException classNotFoundException) {
    }

        return localPersons;
}

// Get person on personId in file
public Customers getPersonOnPersonId(String fileLocation, int personId) {
    Customers localPerson = null;

    try {
        File f = new File(fileLocation);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                Customers tempPerson = (Customers) ois.readObject();

                if(personId == tempPerson.getPersonId()) {
                    localPerson = tempPerson;
                    break;
                }
            }
        } catch (EOFException e) {

        }
    } catch (IOException iOException) {
    } catch (ClassNotFoundException classNotFoundException) {
    }

    return localPerson;
}

// Get persons on firstname in file
public List<Customers> getPersonsOnFirstName(String fileLocation, String firstName) {
    List<Customers> localPersons = new ArrayList<>();

    try {
        File f = new File(fileLocation);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                Customers tempPerson = (Customers) ois.readObject();

                if(firstName.equals(tempPerson.getFirstName())) {
                    localPersons.add(tempPerson);
                }
            }
        } catch (EOFException e) {

        }
    } catch (IOException iOException) {
    } catch (ClassNotFoundException classNotFoundException) {
    }

    return localPersons;
}

// Get persons on lastname in file
public List<Customers> getPersonsOnLastName(String fileLocation, String lastName) {
    List<Customers> localPersons = new ArrayList<>();

    try {
        File f = new File(fileLocation);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                Customers tempPerson = (Customers) ois.readObject();

                if(lastName.equals(tempPerson.getLastName())) {
                    localPersons.add(tempPerson);
                }
            }
        } catch (EOFException e) {

        }
    } catch (IOException iOException) {
    } catch (ClassNotFoundException classNotFoundException) {
    }

    return localPersons;
}

// Insert person in file
public void insertPerson(String fileLocation, Customers person) {
    List<Customers> localPersons = new ArrayList<>();

    // Select block ************************************************
    int maxPersonId = 0;

    try {
        File f = new File(fileLocation);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                Customers tempPerson = (Customers) ois.readObject();
                localPersons.add(tempPerson);
                if(maxPersonId < tempPerson.getPersonId()) {
                    maxPersonId = tempPerson.getPersonId();
                }
            }
        } catch (EOFException e) {

        }
    } catch (IOException iOException) {
    } catch (ClassNotFoundException classNotFoundException) {
    }
    // *************************************************************

    // Set primary key value to the person block *******************
    if(localPersons.isEmpty()) {
        person.setPersonId(1);
    } else {
        maxPersonId++;
        person.setPersonId(maxPersonId);
    }
    // *************************************************************

    // Insert block ************************************************
    try {
        File f = new File(fileLocation);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        localPersons.add(person);

        for(Customers p : localPersons) {
            oos.writeObject(p);
        }
    } catch (FileNotFoundException fileNotFoundException) {
        System.out.println(fileNotFoundException.getMessage());
    } catch (IOException ioexception) {
        System.out.println(ioexception.getMessage());
    }
    // *************************************************************
}

// Update person in file
public void updatePerson(String fileLocation, Customers person) {
    List<Customers> localPersons = new ArrayList<>();

    // Select block ************************************************
    try {
        File f = new File(fileLocation);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                Customers tempPerson = (Customers) ois.readObject();
                if(person.getPersonId() != tempPerson.getPersonId()) {
                    localPersons.add(tempPerson);
                } else {
                    localPersons.add(person);
                }
            }
        } catch (EOFException e) {

        }
    } catch (IOException iOException) {
    } catch (ClassNotFoundException classNotFoundException) {
    }
    // *************************************************************

    // Insert block ************************************************
    try {
        File f = new File(fileLocation);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        for(Customers p : localPersons) {
            oos.writeObject(p);
        }
    } catch (FileNotFoundException fileNotFoundException) {
        System.out.println(fileNotFoundException.getMessage());
    } catch (IOException ioexception) {
        System.out.println(ioexception.getMessage());
    }
    // *************************************************************
}

// Delete person in file
public void deletePerson(String fileLocation, int personId) {
    List<Customers> localPersons = new ArrayList<>();

    // Select block ************************************************
    try {
        File f = new File(fileLocation);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                Customers tempPerson = (Customers) ois.readObject();
                if(personId != tempPerson.getPersonId()) {
                    localPersons.add(tempPerson);
                }
            }
        } catch (EOFException e) {

        }
    } catch (IOException iOException) {
    } catch (ClassNotFoundException classNotFoundException) {
    }
    // *************************************************************

    // Insert block ************************************************
    try {
        File f = new File(fileLocation);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        for(Customers p : localPersons) {
            oos.writeObject(p);
        }
    } catch (FileNotFoundException fileNotFoundException) {
        System.out.println(fileNotFoundException.getMessage());
    } catch (IOException ioexception) {
        System.out.println(ioexception.getMessage());
    }
    // *************************************************************
}
 }