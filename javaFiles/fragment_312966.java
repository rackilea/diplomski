class RefModel {

String PropertyA;
String PropertyB;
String PropertyC;
Model model;
public RefModel(String propertyA, String propertyB, String propertyC, Model model) {...}

@Override
public int hashCode() {
    // only calculate propertyA, propertyB, propertyC
    ...
}

@Override
public boolean equals(Object obj) {
   // only compare propertyA, propertyB, propertyC
   ...
}

@Override
public String toString() {...}

}