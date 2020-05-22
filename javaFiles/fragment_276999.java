public Set(int[] e) {
    this.e = e; // <-- reference to the array
}

v[0] = 999;
v = null; // <-- now v doesn't refer to the array, but e still does.