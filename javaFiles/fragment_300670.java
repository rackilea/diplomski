if (void.class.equals(requiredType) || requiredType.isAssignableFrom(result.getClass())) {
    return result;
}

return CONVERSION_SERVICE.canConvert(result.getClass(), requiredType) //
        ? CONVERSION_SERVICE.convert(result, requiredType) //
        : result;