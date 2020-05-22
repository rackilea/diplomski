package com.stackoverflow.so21326160;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class App {

    public static void main(final String[] args)
    {
        final Map<String, Dog> dogsJanuary = Maps.uniqueIndex(getDogsInJanuaryFromDB(), ToName.INSTANCE);
        final Map<String, Dog> dogsFebruary = Maps.uniqueIndex(getDogsInFebruaryFromDB(), ToName.INSTANCE);

        final Set<String> commonDogNames = Sets.intersection(dogsJanuary.keySet(), dogsFebruary.keySet());
        for (final String commonDogName : commonDogNames) {
            final Dog january = dogsJanuary.get(commonDogName);
            final Dog february = dogsFebruary.get(commonDogName);
            // use the dogs
        }
    }

    static enum ToName implements Function<Dog, String> {
        INSTANCE;

        @Override
        public String apply(final Dog input)
        {
            return input == null ? null : input.getName();
        }
    }
}