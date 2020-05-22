public int hashCode(String nombre )  {
    int hash = new Random().nextInt(); // PLEASE NOTE YOU SHOULD NOT CREATE NEW RANDOM EVERY TIME. CREATE IT ONCE AND JUST USE nextInt()
    hash =  hash*31 + nombre.hashCode();
    System.out.println("hsh " +hash);
    return Math.abs(hash);
}