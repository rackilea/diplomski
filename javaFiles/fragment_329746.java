@Api(tags = "CreditTransfer Entity")
@RepositoryRestController
@PreAuthorize("isAuthenticated()")
public class CreditTransferController {

    @GetMapping("/api/v1/creditTransfers/{id}")
    public ResponseEntity<?> findAll(@PathVariable("id") long id, HttpServletRequest request, Locale locale,
            PersistentEntityResourceAssembler resourceAssembler) {
        //my code

    }

    @DeleteMapping("/api/v1/creditTransfers/{id}")
    public ResponseEntity<?> deleteMovement(@PathVariable("id") long id, HttpServletRequest request, Locale locale,
            PersistentEntityResourceAssembler resourceAssembler) {
        //my code
    }

}