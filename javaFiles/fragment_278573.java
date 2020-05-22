@Override
public ActionErrors validate(
        ActionMapping mapping,
        HttpServletRequest request) {

    // errors return from validator framework (validation.xml file rules)
    ActionErrors errors = super.validate(mapping, request); 

    // Now check other properties (outside of validation.xml)
    if(somefield == ""  ) {
        errors.add("example", new ActionMessage("some.resource.file.key"));
    }

    ... continue to validate your properties

    return errors;
    }