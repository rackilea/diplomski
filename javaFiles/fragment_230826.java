package com.google.inject;

import java.util.Set;

import com.google.inject.internal.MoreTypes;

public class Types {
    public static <T> TypeLiteral<Set<T>> setOf(TypeLiteral<T> lit) {
        return new TypeLiteral<Set<T>>(new MoreTypes.ParameterizedTypeImpl(null, Set.class, lit.getType())); 
    }
}