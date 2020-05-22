String[] data = {"quick", "brown", "fox"};
System.out.println(
    String.join(
        " "
    ,   Arrays.stream(data)
           .map(s -> new StringBuilder(s).reverse().toString())
           .toArray(String[]::new)
    )
);