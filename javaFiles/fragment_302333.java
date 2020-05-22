public class RentEntity {
    private String[] isbn;
    private String username;

    public String[] getIsbn() {
        return isbn;
    }

    public void setIsbn(String[] isbn) {
        this.isbn = isbn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = { "application/json" })
public void newRent(@RequestBody RentEntity data) {
    rentService.newRent(data.getIsbn(), data.getUsername());
}