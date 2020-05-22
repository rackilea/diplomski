database = FirebaseDatabase.getInstance().getReference("notificacionesAdmin/");
final String key = database.push().getKey();
database.child(key).setValue(notificacion).addOnCompleteListener(new OnCompleteListener<Void>() {
    @Override
    public void onComplete(@NonNull Task<Void> task) {
        // Here use the key!
    }
});