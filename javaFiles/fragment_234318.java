public Interface I { }

private class Impl implements I {
}

I buildI() {
    return new Impl();
}