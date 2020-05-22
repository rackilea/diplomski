try {
    obj = objIn.readObject();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}

try {
    emp = (Employee)objIn.readObject();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}