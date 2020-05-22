assertThat(characterAges).matches(
            (Map<Character, Integer> t)
            -> t.entrySet().stream().anyMatch((Map.Entry<Character, Integer> t1)
                    -> "Frodo".equals(t1.getKey().getName()) && 34 == t1.getValue()),
            "is Frodo and 34 years old"
    );