public static MarkStudentFragment newInstance(MyClass inputClass, int inputPosition) {
    MyFragment fragment = new MyFragment();
    dataClass = inputClass;
    position = inputPosition
    return fragment;
}