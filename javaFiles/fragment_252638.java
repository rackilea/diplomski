public class Auditorium implements Serializable{

    private static final long serialVersionUID = 6752903482239784124L;

    private final DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");

    private String auditorium;
    private LocalTime beginLesson;
    private Date date;
    private String dayOfWeekString;
    private String discipline;
    private LocalTime endLesson;
    private String kindOfWork;
    private String lecturer;
    @Override
    public String toString() {
        return "Auditorium [auditorium=" + auditorium + ", beginLesson=" + beginLesson.toString(fmt) + ", date=" + date
                + ", dayOfWeekString=" + dayOfWeekString + ", discipline=" + discipline + ", endLesson=" + endLesson.toString(fmt)
                + ", kindOfWork=" + kindOfWork + ", lecturer=" + lecturer + "]";
    }

    ... getter and setters

}