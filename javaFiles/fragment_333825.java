import net.sf.saxon.s9api.ExtensionFunction;
import net.sf.saxon.s9api.ItemType;
import net.sf.saxon.s9api.OccurrenceIndicator;
import net.sf.saxon.s9api.QName;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.SequenceType;
import net.sf.saxon.s9api.XdmAtomicValue;
import net.sf.saxon.s9api.XdmValue;

public class Test implements ExtensionFunction {

    @Override
    public QName getName() {
        return new QName("http://some.namespace.com", "test");
    }

    @Override
    public SequenceType getResultType() {
        return SequenceType.makeSequenceType(ItemType.STRING, OccurrenceIndicator.ONE);
    }

    @Override
    public net.sf.saxon.s9api.SequenceType[] getArgumentTypes() {
        return new SequenceType[] {};
    }

    @Override
    public XdmValue call(XdmValue[] arguments) throws SaxonApiException {
        String result = "Saxon is being extended correctly.";
        return new XdmAtomicValue(result);
    }

}