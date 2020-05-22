public static void main(String[] args) {
    new Bug<>(){};
}

static class Bug<T> {

    Bug() {
        test(new ParameterizedTypeReference<>(){});
    }

    void test(ParameterizedTypeReference<T> typeReference) {
    }
}