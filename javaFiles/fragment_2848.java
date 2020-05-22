String[] text = {
        "123hello123boy123guy123girl", // 123hello123boy123guy 
        "hello123boy"// hello
};
for (String s: text) {
    System.out.println(
        Arrays.toString(
            s.split("123(?=((?!123).)*?$)")
        )
    );
}