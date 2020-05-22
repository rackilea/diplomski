import java.util.HashMap;
import java.util.Map;

public class MazeNode {

    public enum SlotValue {
        empty(0), start(1), wall(2), visited(3), end(9);

        protected int m_representation;

        SlotValue(int representation) {
            m_representation = representation;

        }

        private static final Map<Integer, SlotValue> mapping = new HashMap<Integer, SlotValue>();

        static {
            for (SlotValue slotValue : SlotValue.values()) {
                mapping.put(slotValue.m_representation, slotValue);
            }
        }

        public static SlotValue fromRepresentation(int representation) {
            SlotValue slotValue = SlotValue.mapping.get(representation);
            if (slotValue == null)
                // throw your own exception
                throw new RuntimeException("Invalid representation:" + representation);
            return slotValue;
        }
    }

    private SlotValue m_mazeNodeSlotValue;

    public MazeNode(SlotValue s) {
        m_mazeNodeSlotValue = s;
    }

    public MazeNode(int s) {
        m_mazeNodeSlotValue = SlotValue.fromRepresentation(s);

    }

    public SlotValue getSlotValue() {
        return m_mazeNodeSlotValue;
    }

    public static void main(String[] args) {
        MazeNode m = new MazeNode(2);
        System.out.println(m.getSlotValue());
        m = new MazeNode(9);
        System.out.println(m.getSlotValue());
    }

}