@Override
public ResponseEntity<Void> deleteThing(...)
{
        try {
                myService.deleteThing(...);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (MyException e) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (MyOtherException e) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
}