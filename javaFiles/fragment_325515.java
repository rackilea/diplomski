public class CaseDataModel extends ListDataModel<Case> implements
    SelectableDataModel<Case> {
CaseDAO caseDAO = new CaseDAO();

public CaseDataModel() {
}

public CaseDataModel(List<Case> cases) {
    super(cases);
}

@Override
public Case getRowData(String arg0) {
    List<Case> listOfMyObjet = (List<Case>) caseDAO.findAll();
    for (Case obj : listOfMyObjet) {
        if (String.valueOf(obj.getIdCase()).equals(arg0))
            ;
        return obj;
    }
    return null;
}

@Override
public String getRowKey(Case arg0) {
    return String.valueOf(arg0.getIdCase());
}