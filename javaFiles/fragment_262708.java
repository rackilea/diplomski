doNothing().when(service).updateMet(any(Met.class));

final ArgumentCaptor<Met> captor = ArgumentCaptor.forClass(Met.class);

mockMvc.perform(bla, bla);

verify(service).updateMet(captor.capture());

final Met captured = captor.getValue();

// verify captured Met instance here