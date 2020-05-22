@RestController
@RequestMapping(value="notes/api")
public class NotesRestController {

private GetAllNotesPresenter getAllNotesPresenter;

@Autowired
private NotesDataSource dataSource;

@RequestMapping(value="/all")
public List<Note> getAll(){
    getAllNotesPresenter = new GetAllNotesPresenterImpl(dataSource);
    return getAllNotesPresenter.getAll();
}