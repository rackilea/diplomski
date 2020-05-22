for (Field field : fields) {
    field.setAccessible(true); // Additional line
    System.out.println("Field Name: " + field.getName());
    System.out.println("Field Type: " + field.getType());
    System.out.println("Field Value: " + field.get(person));
}