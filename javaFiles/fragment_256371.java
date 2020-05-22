class Example implements Serializable {

  // See comments on {@link #writeObject} for why this is transient.
  // Should be treated as final, but can't be declared as such.
  private transient Random random;

  //
  // [Guts of the class go here...]
  //

  /**
   * Serialization hook to handle the transient Random field.
   */
  private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
    if (random instanceof SecureRandom) {
      // Write a null to tell readObject() to create a new
      // SecureRandom during deserialization; null is safe to use
      // as a placeholder because the constructor disallows null
      // Randoms.
      //
      // The dataflow cloud environment won't deserialize
      // SecureRandom instances that use sun.security.provider.Sun
      // as their Provider, because it's a system
      // class that's not on the App Engine whitelist:
      // https://cloud.google.com/appengine/docs/java/jrewhitelist
      out.writeObject(null);
    } else {
      out.writeObject(random);
    }
  }

  /**
   * Deserialization hook to initialize the transient Random field.
   */
  private void readObject(ObjectInputStream in)
      throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    Object newRandom = in.readObject();
    if (newRandom == null) {
      // writeObject() will write a null if the original field was
      // SecureRandom; create a new instance to replace it. See
      // comments in writeObject() for background.
      random = new SecureRandom();
      random.nextDouble(); // force seeding
    } else {
      random = (Random) newRandom;
    }
  }
}