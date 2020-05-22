Optional<Foo> fooOptional = fooRepository.findById(id);
if (fooOptional.isPresent()){
    Foo foo = fooOptional.get();
   // processing with foo ...
}
else{
   // alternative processing....
}