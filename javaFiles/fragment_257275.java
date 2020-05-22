package test.good;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class CloneTest {

    private Vector<MATIdentifier> matIds;

    MATIdentifier id1 = new MATIdentifier("first");
    MATIdentifier id2 = new MATIdentifier("second");
    MATIdentifier id3 = new MATIdentifier("third");
    MATIdentifier idDuplicate = new MATIdentifier("first");

    @Before
    public void prepare() {
        matIds = new Vector<MATIdentifier>() {
            @Override
            public boolean add(MATIdentifier mi) {
                if (this.contains(mi)) {
                    return false;
                }
                super.add(mi);
                return true;
            }

            @Override
            public boolean contains(Object o) {
                if (o instanceof MATIdentifier) {
                    for (MATIdentifier mi : this) {
                        if (mi.getIdValue().equals(((MATIdentifier) o).getIdValue())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };
    }

    private void populateVector(Vector<MATIdentifier> vector) {
        vector.add(id1);
        vector.add(id2);
        vector.add(id3);
    }

    /**
     * Tests that adding new values returns true, and adding duplicates returns
     * false, and that the duplicates are not actually added
     */
    @Test
    public void testDuplicateFails() {
        boolean added;
        added = matIds.add(id1);
        assertTrue(added);
        added = matIds.add(id2);
        assertTrue(added);
        added = matIds.add(idDuplicate);
        assertFalse(added);
        assertEquals(2, matIds.size());
    }

    @Test
    public void testDeepCopy() {
        // Start with by pupulating our customized vector
        populateVector(matIds);
        assertEquals(3, matIds.size());
        // Clone the vector
        Vector<MATIdentifier> clone = (Vector<MATIdentifier>) matIds.clone();
        assertEquals(3, clone.size());
        // remove something from the original
        matIds.remove(2);
        assertEquals(3, clone.size());
        assertEquals(2, matIds.size());
        // add something to the original
        matIds.add(new MATIdentifier("New Value"));
        assertEquals(3, clone.size());
        assertEquals(3, matIds.size());
        // add a duplicate to the clone, to ensure that the overridden behavior
        // is present in the clone
        boolean added = clone.add(id1);
        assertFalse(added);

    }

}

class MATIdentifier {
    private String idValue;

    public MATIdentifier(String idValue) {
        this.idValue = idValue;
    }

    public String getIdValue() {
        return idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }

}