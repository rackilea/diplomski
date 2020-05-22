@Service
public class StudentServiceImpl implements StudentService {

private final StudentRepository studentRepository;

public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
}

//others are same
}