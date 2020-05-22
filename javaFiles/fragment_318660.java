@DeleteMapping(value="/listEmploye/{id}")
        public void delete(@PathVariable(name="id") Long id) {
             employe_rep.deleteById(id) ;
        }

        @DeleteMapping(value="/listEmploye/many/{id}")
        public void deleteMany(@PathVariable(name="id") Long id) {
             employe_rep.deleteById(id) ;
        }