for (Object objectLike : figuresArray) {
    if (NameOfInterfaceToImplement.class.isInstance(objectLike)) {
        NameOfInterfaceToImplement interfaceLike = NameOfInterfaceToImplement.class.cast(objectLike);
        interfaceLike.incrementVolume();
    }
}