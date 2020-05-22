@RestController
@RequestMapping("/api")
public class BookService {

    @RequestMapping(value = "/books",
            params = {"isbn"},
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public  List<Book> getByIsbn(@RequestParam(value = "isbn") String isbn){
        StoredProcedureQuery sp = em.createStoredProcedureQuery("name.of.stored.procedure", Book.class);               
        sp.registerStoredProcedureParameter("isbn", String.class, ParameterMode.IN);
        sp.setParameter("isbn", isbn);

        boolean result = sp.execute();
        if (result == true) {
            return sp.getResultList();
        } else {
            // Handle the false for no result set returned, e.g.
            throw new RuntimeException("No result set(s) returned from the stored procedure"); 
        }
}

}