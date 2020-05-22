public ActionForward upload(....)
    {
              errors.add(ActionErrors.GLOBAL_ERROR, new ActionMessage("error.file.maxCols")); 
              saveErrors(request,errors);
              return (new ActionForward(mapping.getInput()));
    }