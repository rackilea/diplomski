Map<Integer, FormSubmission > forms = new HashMap<> ();

//in constructor or static initialisation block:
forms.put(1, () -> { setField(1, "blah");
                     setField(3, "bla");
                     setField(4, "blah blah"); });
//etc.

public void submitForm(Integer i) {
  forms.get(i).submitForm(); //probably want to handle NPE here
}