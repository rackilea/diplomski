if (returnType.isInstance(value)) {
        return returnType.cast(value);
    } else {
        // could be replaced with a return null
        throw new ClassCastException("Exception message");          
    }