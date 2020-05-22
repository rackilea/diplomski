@Controller
class ExceptionHandlingController {

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private Message handleMessage(TaskNotFoundException e) {
       ...
    }

}