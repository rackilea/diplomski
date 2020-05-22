@RestController
public class ReservationResource {

        @RequestMapping("/test") 
        public ResponseEntity<ReservationResponse> getAvaliableRooms(
                @RequestParam(value = "checkin") @DateTimeFormat(iso = ISO.DATE) LocalDate checkin,
                @RequestParam(value = "checkout") @DateTimeFormat(iso = ISO.DATE) LocalDate checkout) {

            return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
        }

        @RequestMapping("/second") 
        public ResponseEntity<ReservationResponse> getAvaliableRooms(
                    @RequestParam(value = "checkin") @DateTimeFormat(iso = ISO.DATE) LocalDate checkin,
                    @RequestParam(value = "checkout") @DateTimeFormat(iso = ISO.DATE) LocalDate checkout) {

                return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
            }
        }