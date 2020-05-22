import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Root {

    private Map<String, Register> registers = new HashMap<String, Register>();

    @XmlElement(name="register")
    private Collection<Register> registerCollection;

    @XmlTransient
    public Map<String, Register> getRegisters() {
        return registers;
    }

    public void setRegisters(Map<String, Register> registers) {
        this.registers = registers;
    }

    private void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        for (Register register : registerCollection) {
            regusters.put(register.getType());
        }
    }

    private void beforeMarshal(Marshaller marshaller) {
        if(null != registers) {
            registerCollection = registers.values();
        }
    }

}