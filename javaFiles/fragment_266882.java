// refreshing lstlibrary to remove selected name
for (String value1 : array1) {
        model1.addElement(value1);// adding elements to model1
    }
    lstlibrary.setModel(model1);// using model1 for lstlibrary


//refreshing lstplaylist to add new selected name
    for (String value2 : array2) {
        model2.addElement(value2);// adding elements to model2
    }
    lstplaylist.setModel(model2);// using model2 for lstplaylist