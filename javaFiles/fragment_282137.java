String result = 
    params.entrySet()
          .stream()
          .reduce(template,
                  (t,e) -> replaceValueByTag(t, e.getKey(), e.getValue()),
                  (s1,s2)->s1); // dummy combiner