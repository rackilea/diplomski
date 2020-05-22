public class CreateOptionEntryTei extends TagExtraInfo {

    public VariableInfo[] getVariableInfo(TagData data) {

        String var = data.getAttributeString("var");

        return new VariableInfo[] { new VariableInfo(var, OptionEntry.class.getName(), true, VariableInfo.NESTED), };
    }
}