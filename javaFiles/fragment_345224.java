@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    Session session;

    @InjectMocks
    EmployeeDaoImpl edi;

    @Test
    public void testSaveEmployee(){
        edi.saveEmployee();

        verify(session, times(1)).save();
    }
}

class Session {
    void save() {
        System.out.println("saving");
    }
}

interface EmployeeDao {
    void saveEmployee();
}

class EmployeeDaoImpl implements EmployeeDao {
    private Session session;

    public EmployeeDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveEmployee() {
        session.save();
    }
}