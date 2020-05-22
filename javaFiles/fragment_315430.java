@Component("userActionsManager")
@Transactional
public class UserActionsManager implements UserActionsManagerInterface {

    @PersistenceContext(unitName = "itsadDB")
    private EntityManager manager;

    @Resource(name = "databaseManager")
    private DB db;

    .
    .
    .

    @SuppressWarnings("unchecked")
    @Override
    @PreAuthorize("hasRole('ROLE_USER') && #username == authentication.name")
    public String giveAnswer(String username, String courseCode, String missionName, String taskCode, String answer) {
        .
        .
        .
        if (!userCanGiveAnswer(user, course, missionTask)) {
            error = "It is forbidden to submit an answer to this task.";
            db.log(error, Log.LVL_MAJOR);
            return error;
        }
        .
        .
        .
        if (correctAnswer) {
            .
            .
            .          
            addCorrectAnswer(newSubmission, result);
            return null;
        }

        newSubmission = new Submission(user, course, missionTask, answer, false);
        manager.persist(newSubmission);
        return error;
    }

    private void addCorrectAnswer(Submission submission, Result result) {
        String var = "lock_addCorrectAnswer";
        Global global = manager.find(Global.class, var);

        if (global == null) { 
            global = new Global(var, 0);
            manager.persist(global);
            manager.flush();
        }
        manager.lock(global, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        manager.persist(submission);
        manager.persist(result);
        manager.flush();

        long submissions = getCorrectSubmissionCount(submission);
        long results     = getResultCount(result);
        if (submissions > 1 || results > 1) throw new EntityExistsException();
    }

    private long getCorrectSubmissionCount(Submission newSubmission) {
        Query q = manager.createQuery("SELECT count(s) FROM Submission AS s WHERE s.missionTask = ?1 AND s.course = ?2 AND s.user = ?3 AND s.correct = true");
        q.setParameter(1, newSubmission.getMissionTask());
        q.setParameter(2, newSubmission.getCourse());
        q.setParameter(3, newSubmission.getUser());
        return (Long) q.getSingleResult();
    }

    private long getResultCount(Result result) {
        Query q = manager.createQuery("SELECT count(r) FROM Result AS r WHERE r.missionTask = ?1 AND r.course = ?2 AND r.user = ?3");
        q.setParameter(1, result.getMissionTask());
        q.setParameter(2, result.getCourse());
        q.setParameter(3, result.getUser());
        return (Long) q.getSingleResult();
    }
}