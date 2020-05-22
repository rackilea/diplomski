FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
                    final String idUsuario = CustomBase64.codificarBase64(autenticacao.getCurrentUser().getEmail());
                    DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase().child("historico").child(idUsuario).child("id");
                    firebase.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                               Toast.makeText(getActivity(), "Exist", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getActivity(), "No Exist", Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });