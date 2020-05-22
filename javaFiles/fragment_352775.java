try {
 animalObj.getClass().getMethod("getAnimal"+abc.charAt(i)).invoke(animalObj);
} catch (SecurityException e) {
// ...
} catch (NoSuchMethodException e) {
// ...
}