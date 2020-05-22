// 1. Define two arrays
    String[] families = null;
    double[] taxes = null;

    // 2. Read file:
    while (infile.hasNextLine()) {
        String personLastName = infile.next();
        // skip first name
        infile.next();
        double personTax = infile.nextDouble();
        // add person data
        if (null == families) {
            // create array for
            families = new String[] { personLastName };
            taxes = new double[] { personTax };
        } else {
            boolean familyExists = false;
            // check existing families
            for (int i = 0; i < families.length; i++) {
                if (personLastName.equals(families[i])) {
                    // got it! add personTax to family owed taxes
                    taxes[i] += personTax;
                    familyExists = true;
                    break;
                }
            }
            if (!familyExists) {
                // Extend arrays to put new family
                // create temp arrays with size+1
                String[] tmpFamilies = new String[families.length + 1];
                double[] tmpTaxes = new double[taxes.length + 1];
                System.arraycopy(families, 0, tmpFamilies, 0, families.length);
                System.arraycopy(taxes, 0, tmpTaxes, 0, taxes.length);
                // set new last elements data
                tmpFamilies[tmpFamilies.length - 1] = personLastName;
                tmpTaxes[tmpTaxes.length - 1] = personTax;
                // replace families and taxes with newly created tmp arrays
                families = tmpFamilies;
                taxes = tmpTaxes;
            }
        }
    }// while
    // Print results
    System.out.println("Found " + families.length + " families and their taxes");       
    for (int i=0;i < families.length; i++)
    {
        System.out.println("family " + families[i] + " owes $" + taxes[i]);
    }