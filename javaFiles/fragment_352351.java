import static org.junit.Assert.*;
import org.junit.Test;

public class SemesterTest
{
    @Test
    public void aNewSemesterShouldHaveANegativeId()
    {
        Semester semester = new Semester(2010, SemesterType.FALL);
        assertEquals(-1, semester.getInternalId());
    }

    @Test
    public void toStringShouldPrintSemesterTypeAndYear()
    {
        Semester semester = new Semester(2010, SemesterType.FALL);
        assertEquals(SemesterType.FALL + " 2010", semester.toString());
    }

    @Test
    public void equalityShouldOnlyDependOnSemesterTypeAndYear()
    {
        Semester aSemester = new Semester(2010, SemesterType.FALL);
        aSemester.setInternalId(1);

        Semester anotherSemester = new Semester(2010, SemesterType.FALL);
        anotherSemester.setInternalId(2);

        assertEquals(aSemester, anotherSemester);
    }
}