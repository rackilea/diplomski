public ResponseEntity<?> foo(...) {
     if (condition1) {
            return new InfoResponseEntity<Info>(new Info());
        }
        return new VoidResponseEntity<Void>();
}