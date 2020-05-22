abstract class AnimalTransformer<T extends Animal> {
  public T decodeAnimalFromBytes(byte[] animalInBytes) {
    return null;
  }
  public static byte[] encodeAnimalInBytes(T animal) {
    return null;
  }
}

class TigerTransformer extends AnimalTransformer<Tiger> {
  public Tiger decodeAnimalFromBytes(byte[] animalInBytes) {
    return new Tiger();
  }
  public byte[] encodeAnimalinBytes(Tiger tiger) {
      return new byte[0];
  }
}